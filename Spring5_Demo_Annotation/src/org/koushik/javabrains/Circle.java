package org.koushik.javabrains;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

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
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle.");
		System.out.println("Circle's center is ("+center.getX() + ", "+center.getY()+")");
		
	}

}
