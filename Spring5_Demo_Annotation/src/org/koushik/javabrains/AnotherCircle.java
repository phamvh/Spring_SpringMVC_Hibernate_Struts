package org.koushik.javabrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

/**
 * This AnotherCircle is to show the annotation "Autowire".
 * @author huypham
 *
 */
public class AnotherCircle implements Shape {
	private Point center;
	
	public Point getCenter() {
		return center;
	}

	@Required
	@Autowired
	/**
	 * Another type possibility to to Autowire is to use @Qualifier, TOGETHER with the @Autowired annotation.
	 * This is helpful when you cannot change the name of the bean in the spring.xml to make it match the
	 * name of the property of this class. Then in the spring.xml, add a qualifier to a bean (say pointA) 
	 * as follows:
	 *     <bean name="PointA" class="org.koushik.javabrains.Point">
	 *        <qualifier value="related_to_AnotherCircle">
	 *        <property name="x" value="0"/>
			  <property name="y" value="0"/>
	 *     </bean>
	 *     
	 * And in this class, for this method, add annotation @Qualifier below the annotation @Autowired as follows:
	 *     @Qualifier("related_to_AnotherCircle")
	 * Make sure the string inside the quotes matches the string defined in the spring.xml. 
	 *     e.g., "related_to_AnotherCircle"
	 * Also, note that some more name spaces have been added to <beans> in spring.xml in order for @Qualifier to work:
	 * Specifically, these are added:
	 * 
	 *        http://www.springframework.org/schema/context 
              http://www.springframework.org/schema/context/spring-context.xsd

	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing AnotherCircle.");
		System.out.println("AnotherCircle's center is ("+center.getX() + ", "+center.getY()+")");
		
	}

}
