package com.wgs.api.aop;

import com.wgs.dto.BaseResult;
import com.ydd.framework.core.exception.ExceptionCode;
import com.ydd.framework.core.exception.ServiceException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 所有service 调用服务 验证结果是否正确
 */
@Aspect
@Component
public class ServiceReturnAop {
    @Pointcut("execution(* com.wgs.api.service..*.*(..))")
    public void result(){

    }

    /**
     * 验证服务逻辑是否调用成功
     * @param res
     */
    @AfterReturning(returning = "res",pointcut = "result()")
    public void doAfterReturn(BaseResult res){
        if(!res.getSuccess()){
            //服务调用失败 抛出异常
            throw new ServiceException(new ExceptionCode(res.getCode(),res.getMessage()));
        }
    }

}
