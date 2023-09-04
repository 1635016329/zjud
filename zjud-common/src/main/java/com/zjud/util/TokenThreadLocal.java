package com.zjud.util;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/29 14:30
 * @description ThreadLocal, 用来保存当前登录用户信息
 */
public class TokenThreadLocal {
    private static ThreadLocal<String> LOGIN_USER_TOKEN = new ThreadLocal<>();

    private TokenThreadLocal() {

    }
    public static String getToken() {
        return LOGIN_USER_TOKEN.get();
    }

    public static void setToken(String token) {
        LOGIN_USER_TOKEN.set(token);
    }

    public static void remove() {
        LOGIN_USER_TOKEN.remove();
    }
}
