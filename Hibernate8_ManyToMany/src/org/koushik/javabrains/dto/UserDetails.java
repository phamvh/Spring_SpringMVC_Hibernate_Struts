package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/*
this tells hibernate to treat this class as an entity
(name="USER_DETAILS") is to map this class to an entity and a table, both with name USER_DETAILS.
Without that, hibernate will use the class name as the table name.

Use the following syntax to just assign the name to the table, but not to the entity: 
@Entity
@Table(name = "USER_DETAILS")

This will not touch the name of the entity.
*/
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	@Id//this tell hibernate that this is the primary key of the UserDetails object.
	@Column (name ="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	// @Basic (..) use this to specify fetching type, etc. Google it!
	@Column (name="USER_NAME") //this can also be put atop of the getter method instead of being atop the variable itself.
	private String userName;
	
	
	/**
	 * The @JoinTable is optional. It is used here to give the intermediate table and its columns readable names.
	 */
	@ManyToMany
	@JoinTable(name="USER_VEHICLE",
	   			joinColumns=@JoinColumn(name="USER_ID"), 
	   			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
