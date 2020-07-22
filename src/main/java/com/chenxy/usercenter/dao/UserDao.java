package com.chenxy.usercenter.dao;

import com.chenxy.usercenter.pojo.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserDO,Integer> {
    UserDO findByUserCodeAndPassword(String userCode, String password);
}
