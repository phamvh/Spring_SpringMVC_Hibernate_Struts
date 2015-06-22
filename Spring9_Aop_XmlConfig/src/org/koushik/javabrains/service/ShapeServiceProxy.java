package org.koushik.javabrains.service;

import org.koushik.javabrains.model.Circle;

/**
 * This is a proxy class. The purpose of this class is to add something to an existing method that is defined somewhere.
 * 
 * @author huypham
 *
 */
public class ShapeServiceProxy extends ShapeService {
	/**
	 * Since the circle is returned from this proxy, before it is returned, we can add any code to here. This is the meaning of a proxy.
	 */
	public Circle getCircle(){
		//And here, you can add any advice methods, which get executed before the getCircle() method executes.
		return super.getCircle();
	}
}
