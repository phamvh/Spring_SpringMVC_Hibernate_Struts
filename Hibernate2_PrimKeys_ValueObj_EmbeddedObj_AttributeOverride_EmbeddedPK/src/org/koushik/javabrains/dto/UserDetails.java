package org.koushik.javabrains.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	/**
	 * //this tell hibernate that this is the primary key of the UserDetails object.
	 */
	@Id
	/**
	 * //this is surrogate key and it is used as index. hibernate will generate it automatically.
	 * GenerationType.AUTO is the option that you let hibernate decides what best strategy to use to generate they key to be unique
	 * GenerationType.IDENTITY is something that MySQL or some other SQL server have. Probably it is the best to use. Maybe hibernate 
	 * can detect it and use it automatically of MySQL is used.
	 * 
	 */
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	/**
	 * If PK is an object itself, then one needs to use the following annotation:
	 * @EmbeddedId
	 */
	private int userId;
	
	// @Basic (..) use this to specify fetching type, etc. Google it!
	@Column (name="USER_NAME") //this can also be put atop of the getter method instead of being atop the variable itself.
	private String userName;
	
	/**
	 * This tells hibernate that this is an embedded var, meaning hibernate will not generate a separate table for this
	 * Since we already annotated the Address class as Embeddable, this @Embedded becomes redundant. 
	 */
	@Embedded
	private Address address;
	
	/**
	 * Having two addresses will cause a table to have two columns with the same name, which is impossible.
	 * Therefore one needs to override the name of the columns to make it not default, thus unique.
	 * To do this, use @AttributeOverride
	 * This will give the office address to have new names of each of its column
	 */
	@AttributeOverrides({
	@AttributeOverride(name="street", column = @Column(name="OFFICE_STREET_NAME")),
	@AttributeOverride(name="city", column = @Column(name="OFFICE_CITY_NAME")),
	@AttributeOverride(name="state", column = @Column(name="OFFICE_STATE_NAME")),
	@AttributeOverride(name="zipcode", column = @Column(name="OFFICE_ZIPCODE")),
	
	})
	private Address officeAddress;
	
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * hibernate will ignore this property as this is annotated as transient
	 * Hibernate also ingores Java's transient and static variables.
	 */
	@Transient 
	private String temp;
	
	public int getUserId() {
		return userId;
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
