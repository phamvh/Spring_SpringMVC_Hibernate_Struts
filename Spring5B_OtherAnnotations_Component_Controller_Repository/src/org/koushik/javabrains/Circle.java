package org.koushik.javabrains;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 * This class is to show other annotations: 
 *    @Component
 *    @Service     -> for service
 *    @Repository  -> for data
 *    @Controller
 *    
 *    The @Component is the most generic one, while the other three are specific components for spring.
 *    Note that the following tag is added to spring.xml
 *        <context:component-scan base-package="org.koushik.javabrains"></context:component-scan>
 *    This tells spring to scan the given package for the above annotations.
 *
 */
@Component
public class Circle {

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	
	@Required
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	
	
	public void draw() {
		System.out.println("Drawing Circle.");
		System.out.println("Circle's center is ("+center.getX() + ", "+center.getY()+")");
		
	}

}
