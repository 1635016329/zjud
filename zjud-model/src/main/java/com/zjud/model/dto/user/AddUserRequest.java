package com.zjud.model.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/29 15:33
 * @description 添加单个用户请求
 */
@Data
public class AddUserRequest {
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
     * 用户角色, 0 普通用户 1 管理员
     */
    private Integer userRole;

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
