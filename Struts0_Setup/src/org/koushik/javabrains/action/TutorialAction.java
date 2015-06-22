package org.koushik.javabrains.action;

public class TutorialAction {
	public String execute(){
		System.out.println("Hello from execute() failure case");
		return "failure";
	}
}
