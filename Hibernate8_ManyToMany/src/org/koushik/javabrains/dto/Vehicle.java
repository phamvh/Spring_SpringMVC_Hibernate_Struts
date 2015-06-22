package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	/**
	 * mappedBy="vehicle" tells hibernate that the mapping is taken care of by another class UserDetails through its property "vehicle".
	 * Therefore, this Vehicle class is not responsible for creating the intermediate table, which shows the many-to-many relationship.
	 * "vehicle" is the name of the property in the other class (UserDetails), which references this class.
	 * Therefore, hibernate will not create a separate table for this vehicle-user direction. 
	 * For the inverse direction in class UserDetails, we must NOT use mappedBy anymore, because we need a separate table for the user-vehicle direction.
	 * Therefore, one only one intermediate table user_vehicle will be created. 
	 * If we do not use mappedBy in both classes, then TWO intermediate tables (user_vehicle and vehicle_user) will be created, therefore one of them will be redundant.
	 */
	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();
	
	
	
	public Collection<UserDetails> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}
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
