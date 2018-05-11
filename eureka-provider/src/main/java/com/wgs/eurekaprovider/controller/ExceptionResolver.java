package com.wgs.eurekaprovider.controller;

import com.wgs.dto.BaseResult;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.exception.ExceptionCode;
import com.ydd.framework.core.exception.ExceptionCodeTemplate;
import com.ydd.framework.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author xingkong1221
 * @since 2017-09-27
 */
@ControllerAdvice
public class ExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public BaseResult handleServiceException(Throwable ex) {
        ex.printStackTrace();
        ExceptionCode exceptionCode = ((ServiceException) ex).getExceptionCode();
        return new BaseResult(exceptionCode.code,exceptionCode.msg);
    }
}
