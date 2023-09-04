package com.zjud.exception;

import com.zjud.response.ResponseCode;
import com.zjud.response.Response;
import com.zjud.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/7/13 15:52
 * @description 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Response<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response<?> dateFormatExceptionHandler(HttpMessageNotReadableException e) {
        String msg = "日期格式错误，正确日期格式为：yyyy-MM-dd HH:mm:ss";
        log.error(msg, e);
        return ResultUtils.error(4000, msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> businessExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            errorMessage
                    .append(fieldError.getDefaultMessage());
        }
        log.error(errorMessage.toString());
        return ResultUtils.error(ResponseCode.PARAMS_ERROR, ResponseCode.PARAMS_ERROR.getMessage() + errorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    public Response<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ResponseCode.SYSTEM_ERROR, "系统错误");
    }
}
