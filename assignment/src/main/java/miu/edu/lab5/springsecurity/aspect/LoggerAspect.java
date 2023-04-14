package miu.edu.lab5.springsecurity.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {


    @Pointcut("@annotation(miu.edu.lab5.springsecurity.aspect.annotation.LogMe)")
    public void logMeAnnotation(){

    }

    @Before(" logMeAnnotation()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
    }

}
