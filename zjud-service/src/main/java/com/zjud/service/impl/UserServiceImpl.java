package com.zjud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjud.exception.BusinessException;
import com.zjud.model.dto.user.*;
import com.zjud.util.RedisUtil;
import com.zjud.util.ThrowUtils;
import com.zjud.mapper.UserMapper;
import com.zjud.model.entity.User;
import com.zjud.response.Response;
import com.zjud.response.ResponseCode;
import com.zjud.util.ResultUtils;
import com.zjud.service.UserService;
import com.zjud.util.TokenThreadLocal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 86178
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-08-27 15:00:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public Response<Boolean> register(UserRegisterRequest userRegisterRequest) {
        User user = BeanUtil.copyProperties(userRegisterRequest, User.class);
        //用户名是否存在
        Long count = this.query().eq("username", user.getUsername()).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_USERNAME_SAVED);
        //用户邮箱是否存在
        count = this.query().eq("email", user.getEmail()).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_EMAIL_SAVED);
        boolean save = this.save(user);
        ThrowUtils.throwIf(!save, new RuntimeException("用户注册失败"));
        return ResultUtils.success(ResponseCode.USER_REGISTER_SUCCESS, true);
    }

    @Override
    public Response<String> login(UserLoginRequest userLoginRequest) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("email", userLoginRequest.getEmail()).eq("user_password", userLoginRequest.getUserPassword());
        User user = this.getOne(userQueryWrapper);
        ThrowUtils.throwIf(user == null, new BusinessException(ResponseCode.USER_LOGIN_FAIL));

        //jwt
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("userId", user.getUserId());
                put("userRole", user.getUserRole());
            }
        };

        String token = JWTUtil.createToken(map, "gsq".getBytes());
        long expire = 60 * 60 * 24 * 7; //过期时间 7 天
        redisUtil.set("user:login:" + user.getUserId(), token, expire);

        return ResultUtils.success(ResponseCode.USER_LOGIN_SUCCESS, token);
    }

    @Override
    public Response<Boolean> logout() {
        String token = TokenThreadLocal.getToken();
        JWT jwt = JWTUtil.parseToken(token);
        Object userId = jwt.getPayload("userId");
        boolean remove = redisUtil.remove("user:login:" + userId);
        ThrowUtils.throwIf(!remove, new BusinessException(ResponseCode.USER_LOGOUT_FAIL));
        return ResultUtils.success(ResponseCode.USER_LOGOUT_SUCCESS, true);
    }

    @Override
    public Response<Boolean> updateLoginUser(UpdateLoginUserRequest updateLoginUserRequest) {
        String username = updateLoginUserRequest.getUsername();
        String userPassword = updateLoginUserRequest.getUserPassword();
        String email = updateLoginUserRequest.getEmail();
        String org = updateLoginUserRequest.getOrg();

        //用户名是否存在
        Long count = this.query().eq("username", username).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_USERNAME_SAVED);
        //用户邮箱是否存在
        count = this.query().eq("email", email).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_EMAIL_SAVED);
        String token = TokenThreadLocal.getToken();
        JWT jwt = JWTUtil.parseToken(token);

        Long userId = Convert.toLong(jwt.getPayload("userId"));

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("user_id", userId)
                .set("username", username)
                .set("user_password", userPassword)
                .set("email", email)
                .set("org", org);
        boolean update = update(userUpdateWrapper);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.USER_UPDATE_FAIL));
        return ResultUtils.success(ResponseCode.USER_UPDATE_SUCCESS, true);
    }

    @Override
    public Response<Boolean> addUser(AddUserRequest addUserRequest) {
        User user = BeanUtil.copyProperties(addUserRequest, User.class);
        //用户名是否存在
        Long count = this.query().eq("username", user.getUsername()).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_USERNAME_SAVED);
        //用户邮箱是否存在
        count = this.query().eq("email", user.getEmail()).count();
        ThrowUtils.throwIf(count > 0, ResponseCode.USER_EMAIL_SAVED);
        boolean save = save(user);
        ThrowUtils.throwIf(!save, new BusinessException(ResponseCode.USER_ADD_FAIL));
        return ResultUtils.success(ResponseCode.USER_ADD_SUCCESS, true);
    }

    @Override
    public Response<Boolean> removeSingleUser(Long id) {
        if (id == null) {
            throw new BusinessException(ResponseCode.PARAMS_ERROR);
        }
        User user = getById(id);
        ThrowUtils.throwIf(user == null, ResponseCode.USER_NOT_EXIST);
        boolean remove = removeById(id);
        ThrowUtils.throwIf(!remove, ResponseCode.USER_REMOVE_FAIL);
        return ResultUtils.success(ResponseCode.USER_REMOVE_SUCCESS, true);
    }

    @Override
    public Response<Boolean> updateUserByAdmin(UpdateUserRequest updateUserRequest) {
        Long userId = updateUserRequest.getUserId();
        String username = updateUserRequest.getUsername();
        String userPassword = updateUserRequest.getUserPassword();
        Integer userRole = updateUserRequest.getUserRole();
        String email = updateUserRequest.getEmail();
        String org = updateUserRequest.getOrg();

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("user_id", userId)
                .set("username", username)
                .set("user_password", userPassword)
                .set("user_role", userRole)
                .set("email", email)
                .set("org", org);
        boolean update = update(userUpdateWrapper);
        ThrowUtils.throwIf(!update, new BusinessException(ResponseCode.USER_UPDATE_FAIL));
        return ResultUtils.success(ResponseCode.USER_UPDATE_SUCCESS, true);
    }

    @Override
    public Response<List<User>> getUserList() {
        return ResultUtils.success(list());
    }

    @Override
    public Response<User> getUserById(Long id) {
        return ResultUtils.success(getById(id));
    }

    @Override
    public Response<Boolean> removeUserBatch(List<Long> ids) {
        boolean remove = removeBatchByIds(ids);
        ThrowUtils.throwIf(!remove, ResponseCode.USER_REMOVE_SUCCESS);
        return ResultUtils.success(ResponseCode.USER_REMOVE_SUCCESS, true);
    }


}




