package com.chenxy.usercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenxy.common.date.DateUtils;
import com.chenxy.common.exception.BusinessException;
import com.chenxy.common.exception.BusinessExceptionEnum;
import com.chenxy.common.random.RandomUtils;
import com.chenxy.usercenter.constant.UserCenterConstant;
import com.chenxy.usercenter.dao.UserDao;
import com.chenxy.usercenter.pojo.DO.UserDO;
import com.chenxy.usercenter.pojo.DTO.UserLoginDTO;
import com.chenxy.usercenter.pojo.VO.UserLoginVO;
import com.chenxy.usercenter.service.UserService;
import com.chenxy.usercenter.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) throws BusinessException {
        UserDO userDO = userDao.findByUserCodeAndPassword(userLoginDTO.getUserCode(),
                userLoginDTO.getPassword());
        if (userDO == null){
            throw new BusinessException(BusinessExceptionEnum.USER_NOT_EXIST);
        }

        String token = JwtUtils.getJwtToken(userDO);
        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(userDO,userLoginVO);
        userLoginVO.setToken(token);

        String loginKey = UserCenterConstant.USER_CENTER_NAME + ":" +
                userLoginVO.getUserCode() + ":" +
                DateUtils.getDateByFormat("yyyyMMddHHmmss") +
                RandomUtils.getRandomByLen(6);
        stringRedisTemplate.opsForValue().set(loginKey, JSON.toJSONString(userLoginVO),
                JwtUtils.EXPIRE, TimeUnit.MILLISECONDS);
        userLoginVO.setLoginKey(loginKey);
        return userLoginVO;
    }
}
