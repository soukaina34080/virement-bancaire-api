package com.banque.virements.shared.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class AuditAspect {

    @Around("execution(* com.banque.virements.transaction.application.*.*(..))")
    public Object loggerAppel(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("La méthode {} est appelée", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        log.info("la methode {} a été intercepté ", joinPoint.getSignature().getName());
        return result;
    }

}