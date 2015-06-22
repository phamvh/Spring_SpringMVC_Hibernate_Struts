package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	 * You don't have to have this @ManyToOne relationship; it's optional because the User-Vehicle is already one-to-many.
	 * 	This is mainly for convenience when you need to retrieve the user from a Vehicle object.
	 * This will add a column of userId in the vehicle table. The second annotation @JoinColumn(name="USER_ID") is to 
	 * make the column have name "USER_ID", otherwise the default name that hibernate creates would look odd -> "UserDetails_userId".
	 * Note that this is a join column between the two tables, so we have to use @JoinColumn instead of @Column. @Column is not allowed in this case.
	 */
	/*
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	*/
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
