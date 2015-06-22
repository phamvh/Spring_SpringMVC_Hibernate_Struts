package org.koushik.javabrains.service;

import org.koushik.javabrains.model.User;

public class LoginService {
	public boolean verifyLogin(User user){
		if(user.getUserId().equals("huy") && user.getPassword().equals("pham")){
			return true;
		}
		return false;
	}
}
