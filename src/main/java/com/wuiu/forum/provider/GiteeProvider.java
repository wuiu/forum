package com.wuiu.forum.provider;

import com.alibaba.fastjson.JSONObject;
import com.wuiu.forum.dto.AccessTokenDTO;
import com.wuiu.forum.dto.GiteeAccessTokenInfo;
import com.wuiu.forum.dto.GiteeUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class GiteeProvider {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    @Value("${gitee.client.id}")
    private String clientId;
    @Value("${gitee.client.secret}")
    private String clientSecret;
    @Value("${gitee.redirect.url}")
    private String redirectUrl;

    //1.获取用户AccessToken
    public GiteeAccessTokenInfo getAccessToken(String code) {
        AccessTokenDTO dto = new AccessTokenDTO(clientId,clientSecret,code,redirectUrl);
        String url = "https://gitee.com/oauth/token?grant_type=authorization_code";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSONObject.toJSONString(dto), JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            JSONObject json = JSONObject.parseObject(res);
            GiteeAccessTokenInfo info = JSONObject.toJavaObject(json, GiteeAccessTokenInfo.class);
            System.out.println(json.toJSONString());
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //获取用户信息
    public GiteeUser getGiteeUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://gitee.com/api/v5/user?access_token="+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String res = response.body().string();
            JSONObject json = JSONObject.parseObject(res);
            System.out.println(json.toJSONString());
            return JSONObject.toJavaObject(json,GiteeUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
