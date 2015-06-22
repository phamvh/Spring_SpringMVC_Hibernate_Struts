package com.tutorialspoint;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NameException extends RuntimeException{
    private String exceptionMsg;
    
    public NameException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
