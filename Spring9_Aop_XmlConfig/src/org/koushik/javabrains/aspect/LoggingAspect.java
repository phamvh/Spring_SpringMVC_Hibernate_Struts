package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.koushik.javabrains.model.Circle;


/*@Aspect*/ //note that the aspect annotation is no longer here.
//It is now defined in spring.xml
public class LoggingAspect {

	
	
	/*@Pointcut("execution(public * get*(..))")*/ //NOTE: NORE MORE ANNOTATION HERE. IT 'S HAS BEEN MOVED TO spring.xml FILE
	//public void allGetters(){} //this is also not not needed. It is defined in xml.
	
    /* @Around("allGetters()") */ //NOTE: NO MORE ANNOTATION HERE. IT'S HAS BEEN MOVED TO spring.xml FILE
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJointPoint){
    	Object str = null;
    	try{
        System.out.println("Before advice.");
    	
        str = proceedingJointPoint.proceed(); //this actually executes the called method, the one that is adviced my this method.
    	
        //System.out.println("The returned string is "+str.toString());
    	System.out.println("After returning");
    	return str;
    	}catch(Throwable e){
    		System.out.println("Exception occurs");
    	}
    	return str;
    	
    }
}
  














