package com.zjud.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:39
 * @description 响应基类
 */
@Data
public class Response<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public Response(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Response(int code, T data) {
        this(code, data, "");
    }

    public Response(ResponseCode responseCode) {
        this(responseCode.getCode(), null, responseCode.getMessage());
    }
}