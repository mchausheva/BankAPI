package com.sgfs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sgfs.Model.EException;
import com.sgfs.Model.EResponse;
import com.sgfs.Model.EResponse.Status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionalHandler {

	@ExceptionHandler(value = { EException.class })
	public ResponseEntity handleException(EException ex) {
	        log.error("Exception: " + ex.getStatus());
	        
	        
	        String code = ex.getStatus().getStatus();
	        EResponse.Status status = ex.getStatus(); 
	        
	        EResponse res = new EResponse(ex.getStatus(), null, null, null, null, null, null, null);
	        
	        res.setErrorCode(code);
	        res.setErrorDes(status.toString());
	        	        
	        //return new ResponseEntity(ex.getStatus() + "\n" + ex.getStatus().name(), HttpStatus.NOT_FOUND);
	        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@org.springframework.beans.factory.annotation.Autowired(required=true)
//    private EResponse resp ;
//	
//	
//    @ExceptionHandler(EException.class)
//    public ResponseEntity exception(EException excp)
//    {
//       
//        Status st = excp.getStatus();
//        String code = excp.getStatus().getStatus();
//        resp.setErrorCode(st.name());
//        resp.setErrorDes(code);
//        return new ResponseEntity(resp.getErrorCode() + "\n"+  resp.getErrorDes(), HttpStatus.NOT_FOUND) ;
//    }
}
