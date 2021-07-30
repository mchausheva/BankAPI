package com.sgfs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sgfs.Model.EException;
import com.sgfs.Model.EResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionalHandler {

	@ExceptionHandler(value = { EException.class })
	public ResponseEntity handleException(EException ex) {
	        log.error("Exception: " + ex.getStatus());
	                
	        String code = ex.getStatus().getStatus();
	        EResponse.ResStatus status = ex.getStatus(); 
	        
	        EResponse res = new EResponse(ex.getStatus(), null, null, null, null, null, null, null);
	        
	        res.setErrorCode(code);
	        res.setErrorDes(status.toString());
	        
	        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
