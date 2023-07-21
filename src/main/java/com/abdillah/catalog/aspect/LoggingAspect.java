package com.abdillah.catalog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.abdillah.catalog.dto.BookDTO.BookDetailResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.abdillah.catalog.web.*.*(..))")
    private void restAPI() {
    }

    @Pointcut("within(com.abdillah.catalog.web.*)")
    private void withinPointcutExample() {
    }

    @Pointcut("args(com.abdillah.catalog.dto.PublisherDTO.PublisherCreateRequestDTO)")
    private void argsPointExample() {
    }

    @Pointcut("@args(com.abdillah.catalog.annotation.LogThisArg)")
    private void argsAnnotationPointcutExample() {
    }

    @Pointcut("@annotation(com.abdillah.catalog.annotation.LogThisMethod)")
    private void annotationPointcutExample() {
    }

    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect before method executed");
    }

    @After("annotationPointcutExample()")
    public void afterExecutedLogging() {
        log.info("this is log from aspect after method executed");
    }

    @AfterReturning("annotationPointcutExample()")
    public void afterReturnExecutedLogging() {
        log.info("this is log from aspect after method return executed");
    }

    @AfterThrowing("annotationPointcutExample()")
    public void afterThrowExecutedLogging() {
        log.info("this is log from aspect after method throw executed");
    }

    @Around("restAPI()")
    public Object processingTimeLoggin(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            log.info("START {}.{}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("FINISH {}.{} execution time = {}", joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        }

    }
}
