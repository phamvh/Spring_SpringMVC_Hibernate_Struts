package org.koushik.javabrains.model;

import org.koushik.javabrains.aspect.Loggable;

public class Circle {
	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setName() has been called.");
	}
	
	public String setNameAndReturn(String name){
		this.name = name;
		System.out.println("Circle's setNameAndReturn() has been called.");
		return name;
	}
}
