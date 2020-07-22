package com.chenxy.usercenter.controller;

import com.chenxy.common.exception.BusinessException;
import com.chenxy.common.result.CommonResult;
import com.chenxy.usercenter.pojo.DTO.UserLoginDTO;
import com.chenxy.usercenter.pojo.VO.UserLoginVO;
import com.chenxy.usercenter.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user/center")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody UserLoginDTO userLoginDTO) throws BusinessException {
        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return CommonResult.create(userLoginVO);
    }

}
