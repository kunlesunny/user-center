package com.chenxy.usercenter.pojo.DTO;

public class UserLoginDTO {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户登陆密码
     */
    private String password;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
