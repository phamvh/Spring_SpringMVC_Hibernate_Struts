package org.koushik.javabrains.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
/**
 * This will force hibernate to generate a table for each class: parent class or child classes.
 * In the end, there will be three tables: vehicle, twowheeller and fourwheeler, and they share NOTHING.
 */
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 

/**
 * This is very similar to the above commented out strategy.
 * However, the three tables will share data. In Vehicle, all vehicles will be there with their IDs and names.
 * Each child class will has a separate table with its own properties. However, the properties that it inherites
 * from the parent class will stay in the table of the parent class (Vehicle)
 */
@Inheritance(strategy=InheritanceType.JOINED) 
public class Vehicle {
	@Id
	/**
	 * Note that we have to use GenerationType.TABLE in here. 
	 * First, GenerationType.AUTO will use IDENTITY of MySQL, which will throw an exception.
	 * MySQL cannot mix GenerationType.IDENTITY with many tables.
	 */
	@GeneratedValue(strategy = GenerationType.TABLE)
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
