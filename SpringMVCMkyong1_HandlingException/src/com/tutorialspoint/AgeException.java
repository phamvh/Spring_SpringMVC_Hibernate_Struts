package com.tutorialspoint;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If there is NO handler for this AgeException, a http response of 404 with message "You're too young, baby"
 * will be returned. Try to run it to see. Enter age < 5.
 * 
 * However, if there is a handler for this exception, it is up to the handler to return whatever it wants.
 * For this purpose, the handler method for AgeException in class StudentController has been commented out.
 */

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="You're too young, baby")
public class AgeException extends RuntimeException{
private String exceptionMsg;
    
    public AgeException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
