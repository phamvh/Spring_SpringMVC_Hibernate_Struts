package com.tutorialspoint;

/**
 * Just some dummy exception in order to show how to handle multiple types of exceptions
 * in this project.
 * @author huypham
 *
 */
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
