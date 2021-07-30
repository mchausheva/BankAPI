package com.sgfs.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.sgfs.Model.EResponse.ResStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EException extends RuntimeException{
	
		private static final long serialVersionUID = 1L;
		
		private final ResStatus status;
	   
	    public EException(ResStatus status) {
	    	super();
	        this.status = status;
	    }
	   
	    public ResStatus getStatus() {
	        return this.status;
	    }
	   
	    public EException(String message, Throwable cause, ResStatus status) {
	        super(message,cause);
	        this.status = status;
	    }
	   
	    public EException(Throwable cause, ResStatus status) {
	        super(cause);
	        this.status = status;
	    }
	   
	    public EException(String message, ResStatus status) {
	        super(message);
	        this.status = status;
	    }
}
