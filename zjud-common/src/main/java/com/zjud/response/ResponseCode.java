package com.zjud.response;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:40
 * @description 错误码
 */
public enum ResponseCode {

    //成功
    SUCCESS(2000, "成功"),
    USER_REGISTER_SUCCESS(2001, "用户注册成功"),
    USER_LOGIN_SUCCESS(2002, "用户登录成功"),
    USER_LOGOUT_SUCCESS(2004, "用户登出成功"),
    USER_ADD_SUCCESS(2005, "用户添加成功"),
    USER_REMOVE_SUCCESS(2006, "用户删除成功"),
    USER_UPDATE_SUCCESS(2008, "用户信息更新成功"),
    NOTICE_PUBLISH_SUCCESS(3100, "公告发布成功"),



    //失败
    FAIL(3000, "失败"),
    USER_EMAIL_SAVED(3001, "用户邮箱已存在"),
    USER_USERNAME_SAVED(3002, "用户名已存在"),
    USER_LOGIN_FAIL(3003, "登录失败：邮箱或密码错误"),
    USER_NO_LOGIN(3004, "未登录"),
    USER_LOGOUT_FAIL(3005, "用户登出失败"),
    USER_ADD_FAIL(3006, "用户添加失败"),
    USER_REMOVE_FAIL(3007, "用户删除失败"),
    USER_NOT_EXIST(3008, "该用户不存在"),
    USER_UPDATE_FAIL(3009, "用户信息更新失败"),
    NOTICE_PUBLISH_FAIL(3100, "公告发布失败"),



    PARAMS_ERROR(4000, "请求参数错误"),
    NO_AUTH_ERROR(4001, "无权限"),
    NOT_FOUND_ERROR(4040, "请求数据不存在"),
    FORBIDDEN_ERROR(4030, "禁止访问"),
    SYSTEM_ERROR(5000, "系统内部异常"),
    OPERATION_ERROR(5001, "操作失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
