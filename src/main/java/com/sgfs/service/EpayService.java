package com.sgfs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sgfs.Model.EException;
import com.sgfs.Model.ERequest;
import com.sgfs.Model.EResponse;
import com.sgfs.Model.EResponse.Status;
import com.sgfs.Model.Merchant;
import com.sgfs.Model.MerchantList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EpayService {
	
	public static List<Merchant> merchantsList = new ArrayList<>();
	{
		Merchant m = new Merchant(
				"0021", "Jonh", "john", "gjk", true, 1, "Cat1",
				1, false, true, "", "", "", "");
		merchantsList.add(m);
	
		m = new Merchant(
				"0031", "Maria", "john", "gjk", false, 2, "Cat2",
				2, true, true, "", "", "", "");
		merchantsList.add(m);

		m = new Merchant(
				"0041", "Jefree", "john", "gjk", true, 3, "Cat3",
				1, false, false, "", "", "", "");
		merchantsList.add(m);

		m = new Merchant(
				"0051", "Josh", "john", "gjk", true, 4, "Cat4",
				2, true, true, "", "", "", "");
		merchantsList.add(m);

		m = new Merchant(
				"0061", "Joanh", "john", "gjk", true, 5, "Cat5",
				1, false, false, "", "", "", "");
		merchantsList.add(m);
	}
	
	
	public LocalDate getDate() {
		Random rand = new Random();
		int min = (int) LocalDate.of(2017, 1, 1).toEpochDay();
		int max = (int) LocalDate.of(2027, 12, 31).toEpochDay();
		int random = min + rand.nextInt(max - min);
		LocalDate randomDate = LocalDate.ofEpochDay(random);
		
		return randomDate;
	}

	private int getRand (int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public MerchantList getMerchant() {
		log.info("Start getMerchants: ");
		
		MerchantList m = new MerchantList (merchantsList.size(), merchantsList);
		return m;
	}

	public EResponse checkBill(ERequest request) {
		log.info("Start checkBill: ");
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());

		int amount = getRand(1, 200);
		
		EResponse response = getResponse(new EResponse(Status.OK, getDate(), amount, null, null, "", "", "123456789"));	
	    return response;
	}
	
	public EResponse checkBillBlocked(ERequest request) {
		log.info("Start checkBillBlocked: ");
		log.debug("ERequest.getTransactionId - > " + request.getTransactionId());
		log.debug("ERequest.getDt - > " + request.getDt());
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());
		
		int amount = getRand(1, 200);
		int fee = getRand(1, 200);
		int total = amount + fee;
		
		EResponse response = getResponse(new EResponse(Status.OK, getDate(), amount, fee, total, "", "", null));	
	    return response;
	}
	
	public EResponse payBill(ERequest request) {
		log.info("Start payBill: ");
		log.debug("ERequest.getTransactionId - > " + request.getTransactionId());
		log.debug("ERequest.getDt - > " + request.getDt());
		log.debug("ERequest.getAmount -> " + request.getAmount());
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());
		
		return getResponse(new EResponse(Status.OK, null, null, null, null, null, null, null));
	}
	
	public EResponse reverseBill(ERequest request) {
		log.info("Start reverseBill: ");
		log.debug("ERequest.getTransactionId - > " + request.getTransactionId());
		log.debug("ERequest.getDt - > " + request.getDt());
		log.debug("ERequest.getAmount -> " + request.getAmount());
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());
		
		return getResponse(new EResponse(Status.OK, null, null, null, null, null, null, null));
	}
	
	public EResponse getResponse(EResponse success) {
		int random = getRand(1, 50);
		
		log.debug("random value: " + random);
		switch (random) {
		case 1:
			throw new EException(Status.NO_PENDING_DUE);
		case 2:
			throw new EException(Status.MERCHANT_REF_NOT_FOUND);
		case 3:
			throw new EException(Status.INVALID_CODE);
		case 4:
			throw new EException(Status.CARD_LOCKED);
		case 5:
			throw new EException(Status.TEMPORARYLY_UNAVL);
		case 6:
			throw new EException(Status.GENERAL_ERROR);
		case 7:
			throw new EException(Status.INVALID_DEPOSIT_AMOUNT);
		case 8:
			throw new EException(Status.INVALID_FORMAT);
		case 9:
			throw new EException(Status.DUE_IS_BLOCKED);
		case 10:
			throw new EException(Status.REPEATED_MESSAGE);
		case 11:
			throw new EException(Status.OLD_DUE_PENDING);
		case 12:
			throw new EException(Status.PERIOD_UNAVL);
		case 13:
			throw new EException(Status.NO_INFO_FOR_MERCHANT_REF_NO);

		default:
			log.debug("End with success");
			return success;
		}
	}
	
}

