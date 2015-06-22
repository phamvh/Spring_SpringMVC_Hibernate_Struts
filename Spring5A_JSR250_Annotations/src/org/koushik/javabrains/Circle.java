package org.koushik.javabrains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

public class Circle {

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	/**
	 * The annotation @Required is to ensure that when we create an instance of this bean (Circle), the center property has to be set.
	 * The bean can be created either inside the spring.xml or manually, but if we miss seeting the center to the circle, an error will
	 * be thrown out. 
	 * Note that Simply apply the @Required annotation will not enforce the property checking, you also need to register an 
	 * RequiredAnnotationBeanPostProcessor to aware of the @Required annotation in bean configuration file. See belows:
	 *    <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"></bean>
	 * See spring.xml file for details: 
	 * 
	 */
	@Required
	/**
	 * This @Resource annotation that belongs to Java, not Spring.
	 * It helps you define which Point bean from spring.xml to be used for the center of this circle.
	 * 
	 * If only @Resource is given, without "(name="pointA")", then @Resource will try to match by name "center".
	 * 
	 */
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	
	
	public void draw() {
		System.out.println("Drawing Circle.");
		System.out.println("Circle's center is ("+center.getX() + ", "+center.getY()+")");
		
	}

}
