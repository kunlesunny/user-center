package com.chenxy.usercenter.pojo.VO;

public class UserLoginVO {
    /**
     * 用户登陆成功后的token
     */
    private String token;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 登陆key
     */
    private String loginKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginKey() {
        return loginKey;
    }

    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }
}
