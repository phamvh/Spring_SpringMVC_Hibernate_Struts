package org.koushik.javabrains;

import org.koushik.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//the second argument is to indicate the type of the bean, therefore no casting is needed.
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
		
		
	}
}
