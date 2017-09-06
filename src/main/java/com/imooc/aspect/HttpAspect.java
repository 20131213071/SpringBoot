package com.imooc.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by smx on 2017/7/10.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
//    @Before("execution(public * com.imooc.controller.GirlController.*(..))")
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获得请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //method 类名.方法名,joinPoint需要有入参
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+
                "."+joinPoint.getSignature().getName());
        //param
        logger.info("param= {}",joinPoint.getArgs());
        logger.info("before");
    }
    @After("log()")
    public void doAfter(){
        logger.info("after");
    }
    @AfterReturning(pointcut = "log()",returning = "object")
    public void afterReturning(Object object){
        logger.info("returning ={}"+object.toString());
        }
}
