package org.koushik.javabrains.action;

import com.opensymphony.xwork2.Action;

/**
 * The best practices in this project include:
 * 1) Not returning hard-coded string "success" or "error". Instead, make it "private static String SUCCESS ...", then return it.
 *    Implement interface Action to take advantages of already-defined strings of returned codes.
 * 2) Split the struts.xml into multiple smaller files for better organization.
 *    Use <include> tag to include the files into the main struts.xml
 * 3) Use Alias to hide the real URL by using dummy actions. This allows:
 *    a) Hide the real URL for higher security
 *    b) Users access a page by using an alias, so even if you change an URL or force users to
 *       user a newly updated version of a page, users do NOT need to know the URL of this new page.
 *       Instead, simply redirect the alias to the new URL.
 * 4) Use wild cards (see struts.xml)
 * @author huypham
 *
 */

public class LoginAction implements Action{
	
	//private static String SUCCESS = "success";
	
	
	private String userId;
	private String password;
	
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
