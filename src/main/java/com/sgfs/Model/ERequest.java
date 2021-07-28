package com.sgfs.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ERequest {
	
	private final String merchantId;
	
	private final String subscrNumber;
	
	private final String transactionId;
	
	@JsonFormat(pattern = "yyyyMMddHHmmss")
	private final Date dt;
	
	private final Integer amount;
}
