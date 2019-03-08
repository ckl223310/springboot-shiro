package com.me.yh.rest;

import com.me.utils.http.ResponseMessage;
import com.me.utils.http.Result;
import com.me.yh.entity.UserEO;
import com.me.yh.service.UserService;
import com.me.yh.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 添加类/接口功能描述
 *
 * @author czh
 * date 2019-03-08
 */
@RestController
@RequestMapping("/")
@Api("用户管理")
public class UserController {

    /**
     * 日志信息
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * userService
     */
    private UserService userService;

    @PostMapping("/insert")
    @ApiOperation("新增用户")
    ResponseMessage insert(@RequestBody UserVO userVO) {

        try {
            userService.insertUser(userVO);
            return Result.success();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    @GetMapping("/getUserIdByUserName")
    @ApiOperation("根据用户名获取用户Id")
    ResponseMessage<String> getUserIdByUserName(@RequestParam("userName") String userName) {

        try {
            return Result.success(userService.getUserIdByUserName(userName));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }
}
