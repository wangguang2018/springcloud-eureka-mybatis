package com.wgs.entity.exception;

import com.ydd.framework.core.exception.ExceptionCode;

import java.io.Serializable;

public class ExceptionCodeTemplate implements Serializable{

    public static final ExceptionCode LOGIN_FAILED = ExceptionCode.init(10001,"登录失败");

}
