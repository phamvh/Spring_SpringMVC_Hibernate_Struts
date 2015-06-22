package org.koushik.javabrains.service;

import org.koushik.javabrains.model.Circle;
import org.koushik.javabrains.model.Triangle;

/**
 *  This simple example shows how a factory service works.
 *  To create beans using a factory service, no need to create an ApplicationContext.
 *  Simple create an instance of this factory service, and return a bean that one needs.
 *  Note that this is simple, so in the AopMain class we did not provide code to illustrate that.
 *  It can be done as follows:
 *     	FactoryService factoryService = new FactoryService();
 *      factoryService.getBean("circle");
 *  
 *  
 *  All the words "shapeService", "circle" ... are hardcoded here, but generally they should
 *  come from a resource file (properties file).
 *  
 *  TO achieve AoP with this factory service, say we need an advice whenever a circle is created,
 *  we need a proxy. See ShapeServiceProxy. In the getCircle of this proxy class, we can add any code (as aspect) before the circle is created.
 *  The idea is quite simple. This is just a general way to achieve AoP in Java, not using anything in Spring.
 *  Example:
 *   *  FactoryService factoryService = new FactoryService();
 *      ShapeServiceProxy proxy = (ShapeServiceProxy)factoryService.getBean("shapeService");
 *      proxy.getCircle(); //Anything added inside this method is aspect.
 *      
 */
public class FactoryService {
	public Object getBean(String beanType){
		if(beanType.equals("shapeService"))
			return new ShapeServiceProxy();
		if(beanType.equals("circle"))
			return new Circle();
		if(beanType.equals("triangle"))
			return new Triangle();
		return null;
	}

}
