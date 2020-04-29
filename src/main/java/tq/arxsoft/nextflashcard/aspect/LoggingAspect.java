/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.logging.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 *
 * @author tkudas
 */
@Aspect
@Component
public class LoggingAspect {

   // private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Logger log = Logger.getLogger(this.getClass().getName());

//    @Pointcut("winthin(tq.arxsoft.nextflashcard.controllers..*)")
//    public void ControllerPackagesPointcut() {
//    }

    @Pointcut("execution(* tq.arxsoft.nextflashcard.controllers.*.*(..))")
    public void controllersLayer() {
    }

    @Around("controllersLayer()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //Logger.getLogger(this.getClass().getName()).log(Level.ALL, "TQTQ: Call: " + joinPoint.getSignature().getName());
        log.info("TQTQ: Call: " + joinPoint.getSignature().getName());
        //log.trace("TQTQ: Call: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
