package com.zjud.model.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/29 16:06
 * @description 更新用户信息
 */
@Data
public class UpdateLoginUserRequest {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "用户名不能为空")
    private String userPassword;

    /**
     * 邮箱，账号为邮箱地址
     */
    @NotBlank(message = "用户名不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 所属组织
     */
    @NotBlank(message = "用户名不能为空")
    private String org;
}
