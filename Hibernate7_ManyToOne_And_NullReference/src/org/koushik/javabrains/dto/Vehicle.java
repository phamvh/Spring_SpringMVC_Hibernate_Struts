package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table (name="VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	/**
	 * 
	 * This will add a column of USER_ID in the vehicle table.
	 * The second annotation @JoinColumn(name="USER_ID") is to make the column have name "USER_ID", 
	 * otherwise the default name that hibernate creates would look odd -> "UserDetails_userId".
	 * Note that this is a join column between the two tables, so we have to use @JoinColumn instead of @Column. 
	 * @Column is not allowed in this case.
	 * 
	 * 
	 * In case the vehicle is NOT owned by any user, by default hibernate will throw an exception.
	 * If we allow a vehicle to be free, the we add @NotFound(action = NotFoundAction.IGNORE), 
	 * which tells hibernate to ignore the user, or in other words, the user_id will be empty for this row of the Vehicle table
	 */
	
	@ManyToOne
	@JoinColumn(name="USER_ID") 
	@NotFound(action = NotFoundAction.IGNORE)
	private UserDetails user;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
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
