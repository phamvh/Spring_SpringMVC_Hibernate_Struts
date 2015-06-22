package org.koushik.javabrains.action;

/**
 * You can configure struts2 in the struts.xml so that a specific method is called, instead of just calling
 * the execute() method by default. Do this by adding parameter "method" in the action tag in struts.xml
 * @author huypham
 *
 */

public class TutorialAction {
	
	
	public String getTutorial(){
		
		System.out.println("getTutorial called");
		return "success";
	}
	public String addTutorial(){
		
		System.out.println("addTutorial called");
		return "success";
	}
}
