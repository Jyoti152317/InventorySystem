package com.xyz.Inventory_System.exception;

import org.springframework.http.HttpStatus;

public class ItemException {
	
	private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
    
	public ItemException(String message, Throwable throwable, HttpStatus httpStatus) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
	public Throwable getThrowable() {
		return throwable;
	}
//	public void setThrowable(Throwable throwable) {
//		this.throwable = throwable;
//	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
//	public void setHttpStatus(HttpStatus httpStatus) {
//		this.httpStatus = httpStatus;
//	}
//    
    

    // Getters and setters
	
	

}
