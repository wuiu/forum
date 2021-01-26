package com.wuiu.forum.provider;

import com.alibaba.fastjson.JSONObject;
import com.wuiu.forum.dto.AccessTokenDTO;
import com.wuiu.forum.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;


@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO dto) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSONObject.toJSONString(dto),JSON);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String accessToken = response.body().string().split("&")[0].split("=")[1];
            return accessToken;
        }catch (Exception e){
          e.printStackTrace();
        }
        return null;
    }

    public GithubUser getGithubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            GithubUser githubUser = JSONObject.parseObject(response.body().string(), GithubUser.class);
            return githubUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
