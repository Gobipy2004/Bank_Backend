package com.reserver.bankingApp.exception;

public class ResourceNotFoundException extends RuntimeException{

	String resourcename;
	String fieldname;
	long fieldid;
	
	public ResourceNotFoundException(String resourcename, String fieldname, long fieldid) {
		super();
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldid = fieldid;
	}
	
	public String getMessage() {
		return resourcename+" Not Found For "+fieldname+" = "+fieldid;
	}
	
}
