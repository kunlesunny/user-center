package com.chenxy.usercenter.service;

import com.chenxy.common.exception.BusinessException;
import com.chenxy.usercenter.pojo.DTO.UserLoginDTO;
import com.chenxy.usercenter.pojo.VO.UserLoginVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserLoginVO login(UserLoginDTO userLoginDTO) throws BusinessException;
}
