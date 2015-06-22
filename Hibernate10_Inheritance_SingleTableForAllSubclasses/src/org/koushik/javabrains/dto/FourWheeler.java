package org.koushik.javabrains.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/**
 * This is used to use string "Bike" as the discriminator type for this subclass
 * By default, hibernate uses the name of the class, which is "FourWheeler"
 */
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
