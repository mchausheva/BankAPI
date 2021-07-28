package com.sgfs.Model;

import org.springframework.stereotype.Component;

import com.sgfs.Model.EResponse.Status;

public class EException extends RuntimeException{
	
	   // private static final long serialVersionUID = 3005180L;
	
	    private final Status status;
	   
	    public EException(Status status) {
	    	super();
	        this.status = status;
	    }
	   
	    public Status getStatus() {
	        return this.status;
	    }
	   
	    public EException(String message, Throwable cause, Status status) {
	        super(message,cause);
	        this.status = status;
	    }
	   
	    public EException(Throwable cause, Status status) {
	        super(cause);
	        this.status = status;
	    }
	   
	    public EException(String message, Status status) {
	        super(message);
	        this.status = status;
	    }
}
