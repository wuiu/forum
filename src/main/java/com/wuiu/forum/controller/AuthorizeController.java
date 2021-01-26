package com.wuiu.forum.controller;

import com.alibaba.fastjson.JSONObject;
import com.wuiu.forum.dto.AccessTokenDTO;
import com.wuiu.forum.dto.GithubUser;
import com.wuiu.forum.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;



    @GetMapping("/callback")
    public String getCode(@RequestParam(name = "code") String code,
                          @RequestParam(name = "code") String state){

        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setCode(code);
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        dto.setState(state);
        dto.setRedirect_uri(redirectUrl);
        String accessToken = githubProvider.getAccessToken(dto);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        System.out.printf(JSONObject.toJSONString(githubUser));
        return "index";
    }
}
