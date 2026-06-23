package com.banque.virements.shared.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
    @Around("execution(* com.banque.virements.transaction.application.*.*(..))")
    public Object mesureTempsEsecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long debut = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long fin = System.currentTimeMillis();
        long dureeTotale = fin - debut;
        log.info("La méthode {} a duré {}ms", joinPoint.getSignature().getName(), dureeTotale);
        return result;
    }
}
