package com.zjud.controller;

import com.zjud.model.dto.user.*;
import com.zjud.model.entity.User;
import com.zjud.response.Response;
import com.zjud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/27 13:44
 * @description
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户接口"})
public class UserController {

    @Resource
    private UserService userService;

    // 用户接口

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Response<Boolean> register(@Validated @RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Response<String> login(@Validated @RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }

    @PostMapping("/logout")
    @ApiOperation("用户登出")
    public Response<Boolean> logout() {
        return userService.logout();
    }

    @PutMapping("/update")
    @ApiOperation("修改当前登录用户信息")
    public Response<Boolean> updateLoginUser(@Validated @RequestBody UpdateLoginUserRequest updateLoginUserRequest) {
        return userService.updateLoginUser(updateLoginUserRequest);
    }


    // 管理员接口

    @PostMapping("/admin/addUser")
    @ApiOperation("添加单个用户")
    public Response<Boolean> addUser(@Validated @RequestBody AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }

    @DeleteMapping("/admin/remove/{id}")
    @ApiOperation("删除单个用户")
    public Response<Boolean> removeSingleUser(@PathVariable Long id) {
        return userService.removeSingleUser(id);
    }

    @DeleteMapping("/admin/removeBatch")
    @ApiOperation("批量删除用户")
    public Response<Boolean> removeUserBatch(@RequestBody List<Long> ids) {

        return userService.removeUserBatch(ids);
    }

    @PutMapping("/admin/updateByAdmin")
    @ApiOperation("修改单个用户信息(管理员)")
    public Response<Boolean> updateUserByAdmin(@Validated @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUserByAdmin(updateUserRequest);
    }

    @GetMapping("/admin/list")
    @ApiOperation("获取用户列表")
    public Response<List<User>> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/admin/detail/{id}")
    @ApiOperation("根据id获取用户信息")
    public Response<User> getUserById(@PathVariable @NotNull Long id) {
        return userService.getUserById(id);
    }

}
