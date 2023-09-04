package com.zjud.model.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/28 10:05
 * @description 用户注册请求DTO
 */
@Data
public class UserLoginRequest {
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String userPassword;

    /**
     * 邮箱，账号为邮箱地址
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
