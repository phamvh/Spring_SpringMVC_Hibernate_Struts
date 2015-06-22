package org.koushik.javabrains.action;

import org.apache.commons.lang3.StringUtils;
import org.koushik.javabrains.model.User;
import org.koushik.javabrains.service.LoginService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	/**
	 * Now, in login.jsp, we only give the names of the properties, but not the user object as below:
	 		<s:textfield label="Login ID" key="userId"/> 
  			<s:password label="Password" key="password"/> 
  	   In order for struts to assign these properties to object "user" automatically, struts needs to know
  	   what object is model object. To tell struts about that, we implement interface ModelDriven<User>,
  	   which has one single method:
	  	    public User getModel() {
				return user;
			}
	   This method return user, which tells struts that user is model object.
	   Struts then populates or pushes this "user" object (together with all its properties) to the value stack and assign appropriate properties
	   on the value stack to this model object. It will not populate other objects to the value stack if those objects
	   are not model objects.
	 */
	private User user = new User();	
	
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



	@Override
	public User getModel() {
		return user;
	}
}
