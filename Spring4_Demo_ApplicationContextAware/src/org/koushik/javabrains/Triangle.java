package org.koushik.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context = null;
	
	private String beanName;

	public Point getPointA() {
		return pointA;
	}



	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}



	public Point getPointB() {
		return pointB;
	}



	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}



	public Point getPointC() {
		return pointC;
	}



	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}



	public void draw(){
		System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY() + ")");
		System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY() + ")");
		System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY() + ")");
	}



	/**
	 * Spring will call this function when it loads the bean, and therefore the context from Spring will be passed to
	 * this local context of Triangle.
	 * From here, one can use this local context to get other beans.
	 */
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		System.out.println("setApplicationContext(context) - The context is "+context.toString());
		
	}


	/**
	 * This method and the setApplicationContext method are called during the initialization of the bean.
	 */

	@Override
	public void setBeanName(String beanName) {
		System.out.println("setBeanName(String beanName) - The name is this bean is "+beanName);
		this.beanName = beanName;
		
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() - "+ beanName);
		
	}



	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() - " + beanName);
		
	}
	
	/**
	 * This method, and similarly, the myOwnCleanUp() method, are configured in the spring.xml
	 *    <beans default-init-method="myOwnInit" default-destroy-method="myOwnCleanUp">
	 * This tells spring to run these methods as init and destroy.
	 */
	public void myOwnInit(){
		System.out.println("myOwnInit() - "+ beanName);
	}
	public void myOwnCleanUp(){
		System.out.println("myOwnCleanUp() - "+ beanName);
	}
}
