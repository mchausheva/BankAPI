package com.sgfs.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@XmlRootElement(name = "e_response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Merchant {

	@XmlElement(name = "merchant_id")
	private final String merchantId;

	@XmlElement(name = "full_name")
	private final String fullName;

	@XmlElement(name = "web_name")
	private final String webName;

	@XmlElement(name = "subscr_number_type")
	private final String subscrNumberType;

	private final Boolean active;

	private final int category;

	@XmlElement(name = "category_name")
	private final String categoryName;

	@XmlElement(name = "merchant_type")
	private final int merchantType;

	@XmlElement(name = "merchant_partial")
	private final Boolean merchantPartial;

	@XmlElement(name = "merchant_invoice")
	private final Boolean merchantInvoice;

	@XmlElement(name = "merchant_short_desc")
	private final String merchantShortDesc;

	@XmlElement(name = "merchant_long_desc")
	private final String merchantLongDesc;

	@XmlElement(name = "subscr_number_re")
	private final String subscrNumberRe;

	@XmlElement(name = "subscr_number_re_help")
	private final String subscrNumberReHelp;
}
