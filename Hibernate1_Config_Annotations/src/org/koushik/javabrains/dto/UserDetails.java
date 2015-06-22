package org.koushik.javabrains.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
this tells hibernate to treat this class as an entity
(name="USER_DETAILS") is to map this class to an entity and a table, both with name USER_DETAILS.
Without that, hibernate will use the class name as the table name.

Use the following syntax to just assign the name to the table, but not to the entiry: 
@Entity
@Table(name = "USER_DETAILS")

This will not touch the name of the entity.
*/
@Entity (name="USER_DETAILS")
public class UserDetails {
	@Id//this tell hibernate that this is the primary key of the UserDetails object.
	@Column (name ="USER_ID")
	private int userId;
	
	// @Basic (..) use this to specify fetching type, etc. Google it!
	@Column (name="USER_NAME") //this can also be put atop of the getter method instead of being atop the variable itself.
	private String userName;
	
	@Temporal (TemporalType.DATE) //this tells hibernate to use Date only, not time.
	private Date joinedDate;
	private String Address;
	
	/**
	 * This indicates large object, incase description needs a long text.
	 */
	@Lob
	private String description;
	
	/**
	 * hibernate will ignore this property as this is annotated as transient
	 * Hibernate also ingores Java's transient and static variables.
	 */
	@Transient 
	private String temp;
	
	public int getUserId() {
		return userId;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
