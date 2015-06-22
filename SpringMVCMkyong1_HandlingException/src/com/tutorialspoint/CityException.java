package com.tutorialspoint;

public class CityException extends RuntimeException{
    private String exceptionMsg;
    
    public CityException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
