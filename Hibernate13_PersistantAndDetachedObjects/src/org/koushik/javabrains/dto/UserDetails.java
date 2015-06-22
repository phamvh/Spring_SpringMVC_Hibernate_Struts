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
 * This tells hibernate that when an object changes state from DETACHED to PERSISTANT (using session.update()),
 * only call session.update() if there has been changes made to the object of this class.
 * Hibernate does so by first calling "select...", and it compares with the object (which came to being persistent from being detached)
 */
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
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
