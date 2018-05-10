package com.wgs.api.controller;

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
    @ExceptionHandler(Exception.class)
    public ResponseDTO handleServiceException(Throwable ex) {
        // 默认异常信息
        ResponseDTO ret = new ResponseDTO(ExceptionCodeTemplate.SERVICE_EXCEPTION);

        if (ex instanceof ServiceException) {
            ret.setErrorMsg(ex.getMessage());

            //判断异常码是否存在
            ExceptionCode exceptionCode = ((ServiceException) ex).getExceptionCode();
            if (exceptionCode != null) {
                ret.setExceptionCode(exceptionCode);
            }
        } else {
            ret.setErrorMsg(ex.getMessage());
            logger.error("系统出现异常，原因：" + ex.getMessage(), ex);
        }

        return ret;
    }
}
