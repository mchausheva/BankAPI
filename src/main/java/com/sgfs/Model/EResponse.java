package com.sgfs.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
//@XmlRootElement(name = "e_response")
//@XmlAccessorType(XmlAccessType.FIELD)
//@JsonIncludeProperties
public class EResponse {

	private final Status status;
	
	@JsonFormat(pattern = "yyyyMMdd")
	private final LocalDate validTo;
	
	private final Integer amount;
	
	private final Integer fee;
	
	private final Integer total;
	
	private final String shortDesc;
	
	private final String longDesc;
	 
	private final String secondId;
	
	@Setter
	private String errorCode;
	
	@Setter
	private String errorDes;


	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum Status {
		OK("00"),
		NO_PENDING_DUE("62"),
		MERCHANT_REF_NOT_FOUND("14"),
		INVALID_CODE("58"),
		CARD_LOCKED("75"),
		TEMPORARYLY_UNAVL("80"),
		GENERAL_ERROR("96"), 
		INVALID_DEPOSIT_AMOUNT("13"),
		INVALID_FORMAT("805"),
		DUE_IS_BLOCKED("70"),
		REPEATED_MESSAGE("94"),
		OLD_DUE_PENDING("49"),
		PERIOD_UNAVL("50"),
		NO_INFO_FOR_MERCHANT_REF_NO("52");
		
		private String status;

		private Status(String status) {
			this.status = status;
		}
		
		@JsonValue
		public String getStatus() {
			return status;
		}
		
		
	}
}
