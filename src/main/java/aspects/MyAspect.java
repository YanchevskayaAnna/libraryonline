package aspects;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    private Logger logger;

    public void addAppender(){

        //  todo  налаштування брати із файла log4j.properties - там уже створений log4j.aspectLogger=INFO, aspect

        logger = Logger.getRootLogger();
        logger.setLevel(Level.INFO);
        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
        logger.addAppender(new ConsoleAppender(layout));

    }

    public void before(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before method " + proceedingJoinPoint.getSignature());
    }

    public void after(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("After method " + proceedingJoinPoint.getSignature());
    }

    public void afterReturning(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("After returning " + proceedingJoinPoint.getSignature());
    }

    public void afterThrowing(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("After throwing " + proceedingJoinPoint.getSignature());
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = null;
        try {
            before(joinPoint);
            object = joinPoint.proceed(); //запускаем наш joinpoint
            after(joinPoint);
            afterReturning(joinPoint);
        } catch (Throwable throwable) {
            afterThrowing(joinPoint);
            throw throwable;
        }

        return object;
    }
}