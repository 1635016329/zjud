package com.zjud.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.zjud.exception.BusinessException;
import com.zjud.response.ResponseCode;
import com.zjud.util.RedisUtil;
import com.zjud.util.TokenThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/27 13:50
 * @description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new BusinessException(ResponseCode.USER_NO_LOGIN);
        }
        final JWT jwt = JWTUtil.parseToken(token);
        Object userId = jwt.getPayload("userId");
        Object rightToken = redisUtil.get("user:login:" + userId);

        if (rightToken == null || !rightToken.equals(token)) {
            throw new BusinessException(ResponseCode.USER_NO_LOGIN);
        }
        //将token存入ThreadLocal中
        TokenThreadLocal.setToken(token);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TokenThreadLocal.remove();
    }
}
