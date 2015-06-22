package org.koushik.javabrains.service;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.dto.User;

public class LoginService {
	Map<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("jon", "Jonnathan");
		users.put("eric", "Eric Smith");
		users.put("jona", "Joane Green");
		
	}
	
	public boolean authenticate(String userId, String password){
		if((password == null ) || (password.trim() == ""))
			return false;
		return true;
	}
	
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserId(userId);
		user.setUserName(users.get(userId));
		return user;
	}
}
