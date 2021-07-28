package com.sgfs.Model;

import java.util.List;

import lombok.Data;

@Data
public class MerchantList {

	private final int merchantCount;
	
	private final List<Merchant> merchantsList;
}
