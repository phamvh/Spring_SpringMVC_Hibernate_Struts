package org.koushik.javabrains;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Component here is to register this as a bean 
 * and this is also the way a listener is registered to event. 
 * No thing else needed to do, such as addListener, etc.
 * 
 * However, the question is: how does spring know which which event to listen to? Or does this listen to all events?
 * Looks like this listens to all personal event classes that extend ApplicationEvent. So maybe one needs to check 
 * what event that is (from the argument event below) and decide what to do? 
 * 
 * --->>>> The question above is not true. We can specify a specific type of event for this listener via template:
 *               (ApplicationListener<DrawEvent>)
 *   Therefore, this only listens to DrawEvent, not other events such as DummyEvent.
 *   If we do not specify a specific type of event in the triangle brackets, then this listener will listen to all ApplicationEvent, and
 *   all events that extend it, which is BAD. So be careful.
 * @author huypham
 *
 */
@Component
public class MyEventListener implements ApplicationListener<DrawEvent>{

	/**
	 * This method is only called when a DrawEvent happens. It does not react to other events.
	 */
	@Override
	public void onApplicationEvent(DrawEvent event) {
		System.out.println(event.toString());
		
	}

}
