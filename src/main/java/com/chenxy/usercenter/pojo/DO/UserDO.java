package com.chenxy.usercenter.pojo.DO;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDO {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    @Column
    private String username;
    /**
     * 用户密码
     */
    @Column
    private String password;
    /**
     * 用户性别
     */
    @Column
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
