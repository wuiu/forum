package com.wuiu.forum.model;

public class User {

    private Long id;
    private Long accountId;
    private String login;
    private String token;
    private String name;
    private String avatarUrl;
    private String url;
    private String htmlUrl;
    private Long createTime;
    private Long lastUpdateTime;

    public User() {
    }

    public User(Long accountId, String login, String token, String name, String avatarUrl, String url, String htmlUrl, Long createTime, Long lastUpdateTime) {
        this.accountId = accountId;
        this.login = login;
        this.token = token;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
