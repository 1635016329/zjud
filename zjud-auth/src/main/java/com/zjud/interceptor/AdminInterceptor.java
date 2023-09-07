package com.zjud.interceptor;

import cn.hutool.core.convert.Convert;
import cn.hutool.jwt.JWTUtil;
import com.zjud.enums.UserRoleEnum;
import com.zjud.exception.BusinessException;
import com.zjud.response.ResponseCode;
import com.zjud.util.TokenThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/30 10:37
 * @description 权限校验拦截器
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = TokenThreadLocal.getToken();
        Integer userRole = Convert.toInt(JWTUtil.parseToken(token).getPayload("userRole"));
        if (!userRole.equals(UserRoleEnum.ROOT.getKey())) {
            throw new BusinessException(ResponseCode.NO_AUTH_ERROR);
        }
        return true;
    }
}
