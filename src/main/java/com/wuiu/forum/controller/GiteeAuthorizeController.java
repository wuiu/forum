package com.wuiu.forum.controller;

import com.wuiu.forum.dto.GiteeAccessTokenInfo;
import com.wuiu.forum.dto.GiteeUser;
import com.wuiu.forum.model.User;
import com.wuiu.forum.provider.GiteeProvider;
import com.wuiu.forum.provider.GithubProvider;
import com.wuiu.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
public class GiteeAuthorizeController {
    @Autowired
    private GiteeProvider giteeProvider;
    @Autowired
    private UserService userService;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;


    /**
     * 接受gitee返回的用户授权码code
     * 获取access_token
     * @param code 用户授权码
     * @return
     */
    @GetMapping("/callback")
    public String getCode(@RequestParam(name = "code") String code,
                          HttpServletRequest request,
                          HttpServletResponse response){
        //获取access_token
        GiteeAccessTokenInfo accessToken = giteeProvider.getAccessToken(code);
        GiteeUser giteeUser = giteeProvider.getGiteeUser(accessToken.getAccess_token());
        long currentTimeMillis = System.currentTimeMillis();
        User user = new User(giteeUser.getId(),giteeUser.getLogin(), UUID.randomUUID().toString(),giteeUser.getName(),giteeUser.getAvatar_url(),giteeUser.getUrl(),giteeUser.getHtml_url(),currentTimeMillis,currentTimeMillis);
        Integer save = userService.save(user);
        if(save<=0){
            System.out.println("error");
        }
        request.getSession().setAttribute("user",giteeUser);
        response.addCookie(new Cookie("token",user.getToken()));
        return "index";
    }
}
