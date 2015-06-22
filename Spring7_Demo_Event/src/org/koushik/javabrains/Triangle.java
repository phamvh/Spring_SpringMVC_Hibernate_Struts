package org.koushik.javabrains;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Triangle implements ApplicationContextAware, ApplicationEventPublisherAware{


private ApplicationContext context;	
	
/**
 * This is used to fire (publish) an event. See code below.
 * 		//publishing an event
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
 */
private ApplicationEventPublisher publisher;




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
		
		//publishing an event
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
		//This is just a dummy event.
		DummyEvent dummyEvent = new DummyEvent(this);
		publisher.publishEvent(dummyEvent);
		
		///System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY() + ")");
		///System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY() + ")");
		///System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY() + ")");
	}



	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}



	/**
	 * When spring sees a bean that implement ApplicationEventPublisherAware. 
	 * it will provide the ApplicationEventPublisher to the bean through this function.
	 */

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
