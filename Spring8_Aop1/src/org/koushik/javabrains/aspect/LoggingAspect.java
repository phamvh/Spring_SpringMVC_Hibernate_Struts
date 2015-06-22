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

/**
 * //this tells spring that this class is an aspect class.
 * This class has advising methods (not advised methods). 
 * These methods will get called before/after/around when the advised methods are called.
 *
 */
@Aspect 
public class LoggingAspect {

	//make this advice method run before the execution of method [public void setName(String name)]
	/*@Before("execution(public String getName())") */ 
	
	//restrict this function to only the getName() function of the Circle class.
	/*@Before("execution(public String org.koushik.javabrains.model.Circle.getName())") */
	
	//this will work to all getters that return anything and take zero or more arguments. This is using a wild card *
	//The first * is for anything returned type, the second is to any string after "get". The .. is to catch either none or any arguments
	//One can also specify a package, like this: public * org.koushik.javabrains.model.*.get*(..)
	@Before("execution(public * get*(..))")
	public void LoggingAdvice(){
		System.out.println("Advice @Before run, Get Method called");
	}
	
	/**
	 * This is a point cut called allGetters, another option to the previous way. 
	 * It uses a reference to a dummy method reference (defined below)
	 * You can combine difference references to create a combination
	 */
	@Before("allGetters() && allCircleMethods()")
	public void secondAdvice(){
		System.out.println("Second advice executed");
	}
	
	@Before("allCircleMethods()")
	public void thirdAdvice(JoinPoint jointPoint){ //JointPoint contains the information about the called method
		System.out.println(jointPoint.toString());
		Circle circle = (Circle)jointPoint.getTarget();
	}
	
	@Before("args(String)")
	public void stringArgumentMethods(){
		System.out.println("A method that takes String arguments has been called");
	}
	
	/**
	 * This helps you get not just the argument, but also the returned object - returnString
	 * name in the @(...) is to just declare it, name is the argument of the function stringArgumentMethods is the full declaration
	 * It lets spring know that the type of "name" is a String.
	 * @param name
	 * @param returnString
	 */
	//Just comment this out because our adviced methods do not return a string.
	/*
	@AfterReturning(pointcut="args(name)", returning = "returningString")
	public void stringArgumentMethods(String name, String returnString){
		System.out.println("A method that takes String arguments has been called");
		System.out.println("The returned string is "+returnString);
	}
	*/	
	
	//This helps you get the actual argument of the called method.
	//This is called no matter if the method is successfully executed or not
	@After("args(name)")
	public void stringArgumentMethods2(String name){
		System.out.println("The argument of the method is "+name);
	}
	
	//This is called if the method has been SUCCESSFULLY executed..
	@AfterReturning("args(name)")
	public void stringArgumentMethods3(String name){
		System.out.println("The argument of the method is "+name);
   }
	
	//This is called if there is an exception thrown during the execution of the method.
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void stringArgumentMethods4(String name, Exception ex){
		System.out.println("Exception occurred. The argument of the method is "+name);
		System.out.println("The exception is "+ex.toString());
   }
			
	
	@Pointcut("execution(public * get*(..))")
	public void allGetters(){} //this is a dummy used as a reference. 
	
	//apply to all methods in Circle. It's more readable.
	@Pointcut("within(org.koushik.javabrains.model.Circle)") 
	public void allCircleMethods(){}
	
	
	
	//apply to all methods in the subpackage of model
	@Pointcut("within(org.koushik.javabrains.model..*)") 
	public void SubPackageOfModel(){}
	
	
	//Apply to all methods that take Circle as an argument
    @Pointcut("args(String)")
    public void MethodWithCircleArgument(){}
	
    /*
     * This is more like the combination of @Before and @After
     * */
    //just comment this out to make the code work, because we do not have methods with this syntax.
    /*
    @Around("allGetters()")
    public void myAroundAdvice(ProceedingJoinPoint proceedingJointPoint){
    	Object returnValue = null;
    	//Now we will write code around this method. We can actually skip the execution of the called method.
    	//To skip, simply get rid of the proceedingJointPoint.proceed();
    	try{
    	//Write code before the execution of the method here
        System.out.println("Before advice.");
    	
        //if the method returns a value, you can catch it here by this:
    	//returnValue = proceedingJointPoint.proceed(); //this actually executes the called method, the one that is adviced my this method.
        //otherwise, do not catch a value if the method returns void.
        proceedingJointPoint.proceed(); //this actually executes the called method, the one that is adviced my this method.
    	
    	//Write code after the execution of the method here.
    	System.out.println("After returning");
    	
    	
    	}catch(Throwable e){
    		System.out.println("After throwing");
    		
    	}
    	System.out.println("After Finally");
    	//return returnValue;
    }
    */
    
    /*
     * With this, you don't have to worry about how to specify the name of the methods to be adviced.
     * This will apply to all methods that have the notation Loggable, which is an annotation defined in org.koushik.javabrains.aspect
     * This is much easier and more readable than using wild cards or expression to find methods that this advice applies to.
     * Check out the syntax of the method public String getName() in Circle class, also shown below as a comment.
     * 
     	@Loggable
	    public String getName() {
		return name;
	}
     * */
    @Around("@annotation(org.koushik.javabrains.aspect.Loggable)")
    public void myAroundAdviceForAllMethodWithLoggableAnnotation(ProceedingJoinPoint proceedingJointPoint){
    	//put all code in here
    }
	
	
}
















