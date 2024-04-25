package org.example.wallet.balance.audit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Slf4j
@Aspect
@Component
public class LogAdvice {

    @Pointcut("@annotation(org.example.wallet.balance.audit.LogAction)")
    public void logPointCut() {
    }

    @AfterReturning(pointcut = "logPointCut()")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        ActionType actionType = getActionType(joinPoint);
        saveAction(actionType, ActionStatus.SUCCESS);
    }

    @AfterThrowing(pointcut = "logPointCut()",
        throwing = "e"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
        ActionType actionType = getActionType(joinPoint);
        saveAction(actionType, ActionStatus.FAIL);
    }

    private void saveAction(ActionType actionType, ActionStatus actionStatus) {
        log.info("Action={} done with status={}", actionType, actionStatus);
    }

    private ActionType getActionType(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Annotation annotationLog = methodSignature.getMethod().getAnnotation(LogAction.class);
        if (annotationLog != null)
            return ((LogAction) annotationLog).action();
        return null;
    }
}
