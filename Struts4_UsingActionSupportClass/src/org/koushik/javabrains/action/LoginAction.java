package org.koushik.javabrains.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	
	//private static String SUCCESS = "success";
	
	
	private String userId;
	private String password;
	
	
	public void validate(){
		if(StringUtils.isEmpty(getUserId())){
			//User is blank
			addFieldError("userId", "User ID cannot be blank");
		}
		if(StringUtils.isEmpty(getPassword())){
			//Password blank
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		if(getUserId().equals("huy")  && getPassword().equals("pham")){
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
}
