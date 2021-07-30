package com.sgfs.controller;

import java.util.List;

import com.sgfs.Model.ERequest;
import com.sgfs.Model.EResponse;
import com.sgfs.Model.MerchantList;
import com.sgfs.service.EpayService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/bankApi")
public class HomeController {

	@Autowired
	private EpayService epayService;
	
	 @GetMapping(path = "/") 
	 public String home() {
		 return "home"; 
	 }
 	 
	 @GetMapping(path = "/getMerchantsData",
		 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public MerchantList getMerchantsData(@RequestParam(defaultValue = "bg") String lang) {
		 return epayService.getMerchant(lang);
	 }
	
//	 https://stackabuse.com/get-http-post-body-in-spring
//	 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//	 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	 
	 @PostMapping(path = "/checkBill", 
		 		consumes = "application/json", 
//		 produces = "application/json")
//		 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public EResponse checkBill(@RequestBody ERequest request) {			
		 return epayService.checkBill(request);
	 }
	 
	 @PostMapping(path = "/checkBillBlocked", 
		 		consumes = "application/json", 
//		 produces = "application/json")
//		 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public EResponse checkBillBlocked(@RequestBody ERequest request) {
		return epayService.checkBillBlocked(request);
	 }
	 
	 @PostMapping(path = "/payBill", 
			 		consumes = "application/json", 
	//		 produces = "application/json")
	//		 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public EResponse payBill(@RequestBody ERequest request){
		return epayService.payBill(request);
	 }
	 
	 @PostMapping(path = "/reverseBill", 
		 		consumes = "application/json", 
//		 produces = "application/json")
//		 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	 public EResponse reverseBill(@RequestBody ERequest request) {
		 return epayService.reverseBill(request);
	 }
	 	 
}
