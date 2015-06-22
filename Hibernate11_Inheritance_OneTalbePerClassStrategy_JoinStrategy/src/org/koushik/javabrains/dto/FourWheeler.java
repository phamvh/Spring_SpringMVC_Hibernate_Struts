package org.koushik.javabrains.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
