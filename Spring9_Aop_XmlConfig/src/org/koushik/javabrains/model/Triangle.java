package org.koushik.javabrains.model;

public class Triangle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Triangle setter has been called");
		this.name = name;
	}
}
