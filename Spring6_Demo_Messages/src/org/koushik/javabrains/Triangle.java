package org.koushik.javabrains;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

public class Triangle implements ApplicationContextAware{

/**
 * This is to retrieve other beans (if needed), and/or to get messages from a properties file.
 */
private ApplicationContext context;	
	




public List<Point> getPoints() {
		return points;
	}




	public void setPoints(List<Point> points) {
		this.points = points;
	}




private List<Point> points;

	


	public void draw(){
		
		for(Point point: points){
			System.out.println(context.getMessage("drawing.point", new Object[]{point.getX(), point.getY()}, "Default Point Message", null));
		}
		System.out.println(context.getMessage("greeting", null, "Default Greeting", null));
		///System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY() + ")");
		///System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY() + ")");
		///System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY() + ")");
	}



	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}
}
