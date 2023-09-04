package com.zjud.util;

import com.zjud.exception.BusinessException;
import com.zjud.response.ResponseCode;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:53
 * @description 抛异常工具类
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param responseCode
     */
    public static void throwIf(boolean condition, ResponseCode responseCode) {
        throwIf(condition, new BusinessException(responseCode));
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param responseCode
     * @param message
     */
    public static void throwIf(boolean condition, ResponseCode responseCode, String message) {
        throwIf(condition, new BusinessException(responseCode, message));
    }
}