package com.zjud.util;

import com.zjud.response.Response;
import com.zjud.response.ResponseCode;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:41
 * @description 响应结果工具类
 */
public class ResultUtils {

    private ResultUtils() {
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(2000, data, "成功");
    }

    public static <T> Response<T> success(ResponseCode code, T data) {
        return new Response<>(code.getCode(), data, code.getMessage());
    }


    /**
     * 失败
     *
     * @param responseCode
     * @return
     */
    public static Response error(ResponseCode responseCode) {
        return new Response<>(responseCode);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static Response error(int code, String message) {
        return new Response(code, null, message);
    }

    /**
     * 失败
     *
     * @param responseCode
     * @return
     */
    public static Response error(ResponseCode responseCode, String message) {
        return new Response(responseCode.getCode(), null, message);
    }
}