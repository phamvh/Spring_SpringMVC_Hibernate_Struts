package org.koushik.javabrains;

import org.springframework.context.ApplicationEvent;

/**
 * This is another event just to test how spring choose which lister to add to which event.
 * Seems like a listener is added to all types of events, and then depending on what type of event,
 * you need to decide what to do.
 * @author huypham
 *
 */
public class DummyEvent extends ApplicationEvent{

	public DummyEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "Dummy Event Occurred";
	}

}
