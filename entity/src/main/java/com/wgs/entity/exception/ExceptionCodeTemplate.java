package com.wgs.entity.exception;

import com.ydd.framework.core.exception.ExceptionCode;

public class ExceptionCodeTemplate {
    public static final ExceptionCode LOGIN_FAILED = ExceptionCode.init(10001, "登录失败");

    public static final ExceptionCode SERVER_ERROR = ExceptionCode.init(-1, "服务器异常，请稍后再试");

    public static final ExceptionCode ORDER_ERROR = ExceptionCode.init(10002, "下单失败");

    public static final ExceptionCode MEMBER_IN_VALID = ExceptionCode.init(10003, "用户已被封禁");
}
