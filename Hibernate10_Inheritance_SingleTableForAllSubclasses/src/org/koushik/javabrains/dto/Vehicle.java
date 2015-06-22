package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //this is by default if the annotation @Inheritance is not given,
/**
 *  This is optional to specify the name of the discriminator column and its type.
 *  Be default, the column has name "DTYPE" and takes the name of the class as the value (or type).
 *  Here, the name of the column will be "VEHICLE_TYPE" nad has type String. To give the value of the type, we need to
 *  specify it in the child class using @DiscriminatorValue("Bike") (Check out the syntax in the child classes).
 */
@DiscriminatorColumn(
	name = "VEHICLE_TYPE",
	discriminatorType = DiscriminatorType.STRING	
)
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	
	private String vehicleName;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
