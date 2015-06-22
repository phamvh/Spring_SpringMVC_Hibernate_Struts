package com.gontuseries.model;

/**
 * This is to demonstrate how spring handle a property of Student class, which is a user-defined type (Address),
 * not typical java's type, such as Long, String, ArrayList, etc.
 * @author huypham
 *
 */
public class Address {
	private String country;
	private String city;
	private String street;
	private int zipcode;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	} 
}
