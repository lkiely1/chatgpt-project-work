package com.example.springbootapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Define pointcuts for relevant services
    @Pointcut("execution(* com.example.springbootapp.service.PetService.*(..))")
    public void petServiceMethods() {}

    @Pointcut("execution(* com.example.springbootapp.service.HouseholdService.*(..))")
    public void householdServiceMethods() {}

    // Before Advice
    @Before("petServiceMethods() || householdServiceMethods()")
    public void logBeforeMethodExecution() {
        logger.info("A method in PetService or HouseholdService is about to execute.");
    }

    // After Advice
    @After("petServiceMethods() || householdServiceMethods()")
    public void logAfterMethodExecution() {
        logger.info("A method in PetService or HouseholdService has executed.");
    }

    // After Returning Advice
    @AfterReturning(pointcut = "petServiceMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("PetService method returned with value: {}", result);
    }

    // After Throwing Advice
    @AfterThrowing(pointcut = "householdServiceMethods()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        logger.error("An exception was thrown in HouseholdService: {}", exception.getMessage());
    }

    // Around Advice
    @Around("petServiceMethods()")
    public Object logAroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Starting method: {}", joinPoint.getSignature());
        try {
            Object result = joinPoint.proceed();
            logger.info("Method {} completed successfully", joinPoint.getSignature());
            return result;
        } catch (Throwable ex) {
            logger.error("Method {} threw an exception: {}", joinPoint.getSignature(), ex.getMessage());
            throw ex;
        }
    }
}
