package com.zjud.service;

import com.zjud.model.dto.user.*;
import com.zjud.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjud.response.Response;

import java.util.List;

/**
* @author 86178
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-08-27 15:00:56
*/
public interface UserService extends IService<User> {

    // 用户
    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    Response<Boolean> register(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    Response<String> login(UserLoginRequest userLoginRequest);

    /**
     * 用户登出
     * @return
     */
    Response<Boolean> logout();

    /**
     * 更新当前登录用户信息(用户)
     * @param updateLoginUserRequest
     * @return
     */
    Response<Boolean> updateLoginUser(UpdateLoginUserRequest updateLoginUserRequest);

    //管理员
    /**
     * 添加单个用户
     * @param addUserRequest
     * @return
     */
    Response<Boolean> addUser(AddUserRequest addUserRequest);

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    Response<Boolean> removeSingleUser(Long id);

    /**
     * 更新用户信息(管理员)
     * @return
     */
    Response<Boolean> updateUserByAdmin(UpdateUserRequest updateUserRequest);

    /**
     * 获取用户列表
     * @return
     */
    Response<List<User>> getUserList();

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    Response<User> getUserById(Long id);

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    Response<Boolean> removeUserBatch(List<Long> ids);
}
