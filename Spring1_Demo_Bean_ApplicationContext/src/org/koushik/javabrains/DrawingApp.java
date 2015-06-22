package org.koushik.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;



public class DrawingApp {

	public static void main(String[] args) {
		/*
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
		*/
		//advantage is not to create a file, just give the string as the name.
		//Need to move spring.xml to the class path - inside the src folder.
		//This class has more advantages than BeanFactory
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
		Triangle triangle1 = (Triangle)context.getBean("triangle");
		triangle1.draw();
	}

}































