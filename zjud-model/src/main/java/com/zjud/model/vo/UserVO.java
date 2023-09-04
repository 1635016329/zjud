package com.zjud.model.vo;

import lombok.Data;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/9/1 11:06
 * @description
 */
@Data
public class UserVO {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱，账号为邮箱地址
     */
    private String email;

    /**
     * 所属组织
     */
    private String org;

}
