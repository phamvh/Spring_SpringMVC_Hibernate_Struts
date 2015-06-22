package org.koushik.javabrains.dto;

/**
 * THIS IS MODEL
 * dto stands for "Data Transfer Object", which is a MODEL
 * @author huypham
 *
 */

public class User {

	private String userName;
	private String userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
