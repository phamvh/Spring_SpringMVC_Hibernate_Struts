package org.koushik.javabrains.action;

import org.apache.commons.lang3.StringUtils;
import org.koushik.javabrains.model.User;
import org.koushik.javabrains.service.LoginService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	
	//private static String SUCCESS = "success";
	
	/**
	 * This object is instantiated in the login.jsp as follows.
	 *    Pay attention to the key ="user.userId" where user is the name of the variable in this class: 
	 *       private User user = new User(); 
	 *    No need to create object user at its definition. Struts does that automatically.
	   <s:form action="login">
		  <s:textfield label="Login ID" key="user.userId"/> 
		  <s:password label="Password" key="user.password"/> 
		  <s:submit/>
		</s:form>
	 */
	private User user;
	
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	


	public void validate(){
		if(StringUtils.isEmpty(user.getUserId())){
			//User is blank
			addFieldError("userId", "User ID cannot be blank");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			//Password blank
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	

	public String execute(){
		
		LoginService loginService = new LoginService();
	
		
		
		if(loginService.verifyLogin(user)){
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
}
