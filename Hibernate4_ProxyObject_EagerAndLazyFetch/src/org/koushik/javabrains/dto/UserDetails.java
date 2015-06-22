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
	 * This tells hibernate that this is a collection
	 */
	@ElementCollection(fetch=FetchType.EAGER) //this will cause the whole properties of users (all addresses) to be loaded when user is queried.
	/**
	 * This force the foreign table created for address to have name "USER_ADDRESS" and the foreign key to be USER_ID
	 * Without this, the foreign table would have an unreadable name "UserDetails_listOfAddresses" and the foreign key would be "UserDetails_USER_ID"
	    
	   Note that here we have to use a collection type that supports index. In this case, we use ArrayList.
	   Check out the other method (commented out below this part), which use HashTable, which does not support index. 
	   In result, we could not have a PK for a foreign table.
	 */
	@JoinTable(name="USER_ADDRESS",
    			joinColumns=@JoinColumn(name="USER_ID")	
			)
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	/**
	 * This tells hibernate that this is a collection
	 */
	///////////@ElementCollection
	/**
	 * This force the foreign table created for address to have name "USER_ADDRESS" and the foreign key to be USER_ID
	 * Without this, the foreign table would have an unreadable name "UserDetails_listOfAddresses" and the foreign key would be "UserDetails_USER_ID"
	    
	   HOWEVER, the USER_ADDRESS will not have a Primary key, only a foreign key because HashSet itself does not have any index.
	   To solve this, we need to use a collection that has index, such as ArrayList. Array identifies its elements by index.
	 */
	
	/////////@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID")	)
	/*
	private Set<Address> listOfAddresses = new HashSet<Address>();
	
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	*/
	
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
