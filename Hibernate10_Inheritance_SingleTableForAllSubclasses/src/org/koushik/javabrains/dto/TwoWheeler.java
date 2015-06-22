package org.koushik.javabrains.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/**
 * This is used to use string "Bike" as the discriminator type for this subclass
 * By default, hibernate uses the name of the class, which is "TwoWheeler"
 */
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
