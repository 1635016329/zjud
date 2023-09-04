package com.zjud.exception;

import com.zjud.response.ResponseCode;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:51
 * @description 自定义异常
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
    }

    public BusinessException(ResponseCode responseCode, String message) {
        super(message);
        this.code = responseCode.getCode();
    }

    public int getCode() {
        return code;
    }
}