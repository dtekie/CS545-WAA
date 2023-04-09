package miu.edu.lab4.aspect;

import miu.edu.lab4.domain.Logger;
import miu.edu.lab4.service.LoggerService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Instant;
import java.time.ZoneId;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    private LoggerService loggerService;
    private java.util.logging.Logger logger= java.util.logging.Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* miu.edu.lab4.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result=null;
        long beginTime= System.currentTimeMillis();
        try{
            result= joinPoint.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        try{
            saveLog(joinPoint, beginTime);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time)throws Throwable{
        Logger log= new Logger();
        long start= System.nanoTime();
        joinPoint.proceed();
        long finish=System.nanoTime();
        System.out.println(joinPoint.getSignature().getName()+" takes ns: "+ (finish-start));
        log.setTime(finish-start);
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.setDate(Instant.ofEpochMilli(time).atZone(ZoneId.of("America/New_York")).toLocalDate());
        log.setOperation(request.getMethod());
        log.setPrinciple("Test Principle");
        log.setOperation("Test Operation");
        loggerService.saveLogger(log);

    }
}
