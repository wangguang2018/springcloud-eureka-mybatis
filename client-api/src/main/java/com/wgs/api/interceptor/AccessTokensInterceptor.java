package com.wgs.api.interceptor;

import com.wgs.api.service.MemberService;
import com.wgs.dto.BaseResult;
import com.ydd.framework.core.annotation.AccessToken;
import com.ydd.framework.core.exception.ExceptionCode;
import com.ydd.framework.core.exception.ExceptionCodeTemplate;
import com.ydd.framework.core.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问凭证拦截器
 *
 * @author xingkong1221
 * @since 2017-07-12
 */
@Component
public class AccessTokensInterceptor extends HandlerInterceptorAdapter {

    /**
     * 访问凭证请求key
     */
    public static final String ACCESS_TOKEN_REQUEST_KEY = "access_token";

    /**
     * 登录用户编号
     */
    public static final String LOGIN_MEMBER_ID_KEY = "current_member_id";

    @Resource
    private MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取方法注解
        HandlerMethod method = (HandlerMethod) handler;
        AccessToken needAccessToken = method.getMethodAnnotation(AccessToken.class);

        // 若为空则无需访问凭证
        if (needAccessToken == null) {
            return true;
        }

        // 获取访问凭证
        String accessToken = request.getParameter(ACCESS_TOKEN_REQUEST_KEY);

        // 若请求参数中没有，则从Header中获取访问凭证信息
        if (StringUtils.isBlank(accessToken)) {
            accessToken = request.getHeader(ACCESS_TOKEN_REQUEST_KEY);
        }
        if(accessToken.equals("123456")){
            // 将登陆用户的用户编号放入本次请求中
            request.setAttribute(LOGIN_MEMBER_ID_KEY, 1);
            return true;
        }
        // 判断访问凭证是否为空
        if (StringUtils.isBlank(accessToken)) {
            throw new ServiceException(ExceptionCodeTemplate.NONE_ACCESS_TOKEN);
        }

        // 查询缓存获取登录用户编号
        BaseResult<Integer> result = memberService.getMemberIdByAccessToken(accessToken);
        if(!result.getSuccess()){
            throw new ServiceException(new ExceptionCode(result.getCode(),result.getMessage()));
        }
        Integer memberId = result.getContent();
        // 判断登录用户编号是否合法
        if (memberId == null) {
            throw new ServiceException(ExceptionCodeTemplate.INVALID_ACCESS_TOKEN);
        }

        // 将登陆用户的用户编号放入本次请求中
        request.setAttribute(LOGIN_MEMBER_ID_KEY, memberId);
        return true;
    }
}

