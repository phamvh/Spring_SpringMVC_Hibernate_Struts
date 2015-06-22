package org.koushik.javabrains.model;

import org.koushik.javabrains.aspect.Loggable;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter has been called.");
	}
}
