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
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
/**
 * This is to create a named query at the top of this class, 
 * just so that they can be easily managed because they are not scattered around.
 * To see how this query is accessed, check out the HibernateTest class.
 */
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = ?")
/**
 * native SQL query
 * In this case, the names must match the names of the tables and columns in DB, not the names of classes and properties.
 * Since hibernate cannot automatically detect the type of the returned class from the native SQL query, 
 * we need to tell it by giving the parameter resultClass
 */
@NamedNativeQuery(name = "UserDetails.byName", query="select * from userdetails where username=?", resultClass = UserDetails.class)
public class UserDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userName;
		
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
