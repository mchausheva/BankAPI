package com.sgfs.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Merchant {

	private final String merchantId;

	private final String fullName;

	private final String webName;

	private final String subscrNumberType;

	private final Boolean active;

	private final int category;

	private final String categoryName;

	private final int merchantType;

	private final Boolean merchantPartial;

	private final Boolean merchantInvoice;

	private final String merchantShortDesc;

	private final String merchantLongDesc;

	private final String subscrNumberRe;

	private final String subscrNumberReHelp;
}
