package org.koushik.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * This tells hibernate that the entity of this class must be embedded in another entity.
 * This should be embedded in the container class, which contains this class as a property
 *
 */
@Embeddable //this is still needed when addresses are a collection for a user and stored in a separate table. Otherwise, hibernate won't be able to determine the type the address of a user..
public class Address {
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="ZIPCODE")
	private String zipcode;
	
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
