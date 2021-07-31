package com.sgfs.service;

import java.lang.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sgfs.Model.EException;
import com.sgfs.Model.ERequest;
import com.sgfs.Model.EResponse;
import com.sgfs.Model.EResponse.ResStatus;
import com.sgfs.Model.Merchant;
import com.sgfs.Model.MerchantList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EpayService {
	

	
	public static List<Merchant> merchantsList = new ArrayList<>();
	{
			Merchant m = new Merchant(
					"0000040", "CEZ Electro Bulgaria AD", "CEZ Electro Bulgaria AD", "Customer number", true, 1, "Electricity - payment of bills", 
					1, false, false, "", "Through ePay.bg bills of household and business customers can be paid to CEZ for the city of Sofia and "
							+ "the districts of Blagoevgrad, Kyustendil, Pernik and Sofia districts, Pleven, Lovech, Vratsa, Vidin and Montana. "
							+ "Information required in ePay.bg - 12- digital customer number. Term for payment through ePay.bg - until repayment of the "
							+ "obligation. The term for interest-free payment is indicated in the invoice from CEZ for the respective customer number. \"",
							"^\\\\d{12}$", "Customer number - 12 digits");
			merchantsList.add(m);
	
//		m = new Merchant(
//				"0031", "Maria", "john", "gjk", false, 2, "Cat2",
//				2, true, true, "", "", "", "");
//		merchantsList.add(m);
//
//		m = new Merchant(
//				"0041", "Jefree", "john", "gjk", true, 3, "Cat3",
//				1, false, false, "", "", "", "");
//		merchantsList.add(m);
//
//		m = new Merchant(
//				"0051", "Josh", "john", "gjk", true, 4, "Cat4",
//				2, true, true, "", "", "", "");
//		merchantsList.add(m);
//
//		m = new Merchant(
//				"0061", "Joanh", "john", "gjk", true, 5, "Cat5",
//				1, false, false, "", "", "", "");
//		merchantsList.add(m);
	}
	
	private static List<Merchant> merchantsListBg = new ArrayList<>();
	{
		Merchant mbg = new Merchant(
				"0000040", "ЧЕЗ Електро България", "CEZ Electro Bulgaria AD", "Клиентски номер", true, 1, "Електроенергия - плащане на сметки", 
				1, false, false, "електроснабдяване", "Чрез ePay.bg могат да се плащат сметки на битови и стопански клиенти към ЧЕЗ за град София "
						+ "и областите Благоевград, Кюстендил, Перник и София област, Плевен, Ловеч, Враца, Видин и Монтана. Изисквана информация "
						+ "в ePay.bg - 12-цифрен клиентски номер. Срок за плащане чрез ePay.bg - до погасяване на задължението. Срокът за безлихвено "
						+ "плащане е отбелязан във фактурата от ЧЕЗ за съответния клиентски номер.", "^\\\\d{12}$", "Клиентски номер - 12 цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0000047", "Енерго-Про Продажби АД", "ENERGO-PRO", "Клиентски номер", true, 1, "Електроенергия - плащане на сметки", 1, true, true,
				"Електроснабдителни дружества", "Чрез ePay.bg могат да се плащат текущи сметки към ЕНЕРГО-ПРО Продажби АД за областите Силистра, Добрич,"
						+ " Варна, Шумен, Разград, Русе, Търговище, Горна Оряховица, Велико Търново и Габрово. Не могат да се плащат сметки на фирмени "
						+ "абонати, както и тези, регистрирани за плащане чрез директен дебит (разплащателен влог). Изисквана информация в ePay.bg - "
						+ "10-цифрен клиентски номер. Клиентският номер е отбелязан във фактурата, както и в разписката за платена сметка на каса на "
						+ "дружеството. Информация може да получите и на телефон 0700 800 61. Срок за плащане чрез ePay.bg - до погасяване на задължението. "
						+ "Срокът за безлихвено плащане е отбелязан във фактурата от ЕНЕРГО-ПРО за съответния клиентски номер.", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);

		mbg = new Merchant(
				"0000043", "ЕВН България Електроснабдяване ЕАД", "EVN Electricity Company EAD", "ИТН (номер на измервателна точка)", true, 1, "Електроенергия "
						+ "- плащане на сметки", 1, false, false, "Пренос и разпределение на електрическа енергия", "Чрез ePay.bg могат да се плащат текущи и "
								+ "стари задължения на битови и стопански абонати на ЕВН България Електроснабдяване ЕАД. В ePay.bg се въвежда Клиентски номер "
								+ "(10- цифрен код) или ИТН номер (7-цифрен код), отбелязани във фактурата за плащане. Може да получите допълнителна информация "
								+ "и на телефон на ЕВН България: 0700 1 7777.", "^(?:\\\\d{7}|\\\\d{10})(?:\\\\.[^.]+){0,2}$", "Само цифри");
		merchantsListBg.add(mbg);

		mbg = new Merchant(
				"0000120", "Теленор България ЕАД", "Telenor Bulgaria ", "Абонатен номер", true, 5, "Мобилни оператори", 1, false, false, "мобилен оператор", 
				"Чрез ePay.bg всички клиенти на Telenor могат да заплащат текущите си задължения по фактури.Изисквана информация в ePay.bg - клиентски номер, "
				+ "който може да получите като изпратите SMS със съдържание 11 на номер 1000 или безплатно на *123#. В отговор ще получите Вашия клиентски номер "
				+ "на номера, от който е изпратено съобщението. Срокът за плащане чрез ePay.bg - без прекъсване, до погасяване на задължението.Срокът за безлихвено "
				+ "плащане е посочен във фактурата от Telenor за съответния мобилен/фиксиран номер и в детайлите за задължението в ePay.bg. В случай, че регистрираният "
				+ "мобилен/фиксиран номер е включен в една фактура с други Ваши номера, в  ePay.bg ще имате възможност да платите пълната сума на фактурата, за всички "
				+ "номера.", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);

		mbg = new Merchant(
				"0000800", "Макс Телеком ООД", "Max Telecom ", "Абонатен номер", true, 5, "Мобилни оператори", 1, false, false, "Макс Телеком ООД", 
				"Всички клиенти на Макс Телеком могат да платят задълженията си чрез My Fibank. Необходимо е да въведете клиентския си номер във "
				+ "фактурата, издадена от Макс Телеком.", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0000996", "Новаком Груп ЕООД", "Novacom", "ID на клиент", true, 5, "Мобилни оператори", 1, false, false, "OTT услуги за Вашия дом и офисД", "Новаком е ново"
				+ " поколение ОТТ оператор. За регистрация и получаване на информация за задължение посочете Вашия ID номер в Novacom.bg.", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"1000060", "БТК ЕАД", "VIVACOM", "Клиентски номер", true, 5, "Мобилни оператори", 1, false, false, "Мобилни оператори", "Чрез ePay.bg клиентите на VIVACOM "
				+ "(\\\"\\\"\\\"БТК\\\"\\\"\\\" АД) могат да заплащат текущите си сметки за мобилни услуги, стационарен телефон и ADSL. Изисквана информация в ePay.bg - Клиентски "
				+ "номер, отбелязан във фактурата от VIVACOM (\\\"\\\"\\\"БТК\\\"\\\"\\\" АД). Информация за клиентския номер може да се получи и на телефоните на VIVACOM: 123 - за "
				+ "частни клиенти, 121 - за бизнес клиенти.Срок за плащане чрез ePay.bg - до погасяване на задълженията по фактура. Срокът за безлихвено плащане е посочен във фактурата"
				+ " от VIVACOM (\\\"\\\"\\\"БТК\\\"\\\"\\\" АД) за съответния клиентски номер.", "^(8(7|8|9)\\d{10}|\\d+)$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0001395", "Ти.ком АД", "Novacom", "Абонатен номер", true, 5, "Мобилни оператори", 1, false, false, "за електронен магазин", "Няма налична информация", "^\\d+$", 
				"Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0000426", "Телеком 1 ООД", "PlanetPhone", "Абонатен номер / Телефонен номер", true, 5, "Мобилни оператори", 1, false, false, "Телеком 1 ООД", "Клиентите на PlanetPhone"
				+ " могат да заплащат чрез My Fibank всички свои задължения за телефонни услуги, предоставяни от оператора. Изисквана информация - телефонен номер от PlanetPhone. Краен срок"
				+ " за плащане -до погасяване на задължението.", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0001240", "Сдружение \"НАЦИОНАЛНА АСОЦИАЦИЯ ЗА ЗАЩИТА НА ПАЦИЕНТА\"", "SDRUJENIE \"NACIONALNA ASOCIACIA ZA ZASHTITA NA PACIENTA\"", "Абонатен номер", true, 5, "Мобилни оператори",
				1, false, false, "Телеком 1 ООД", "", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0000608", "НЕТТЕЛ БГ ЕООД", "Еfon", "Телефонен номер или номер на карта", true, 5, "Мобилни оператори", 1, false, false, "МЕГАТЕЛ", "Няма налична информация", "^\\d+$", "Само цифри");
		merchantsListBg.add(mbg);
		
		mbg = new Merchant(
				"0000100", "А1 България ЕАД", "A1 Bulgaria ", "Номер на GSM и 4-цифрения код от фактурата", true, 5, "Мобилни оператори", 1, false, false, "МЕГАТЕЛ", "За да регистрирате за плащане услугата,"
				+ " която използвате към А1 България ЕАД, въведете слято номера на услугата и 4-цифрен ПИН код от фактура. За абонати на мобилна услуга мобилният номер е във формат 08XXXXXXXX. Номерът на "
				+ "фиксираната услуга е 12 цифри и във формат  20XXXXXXXXXX – Телевизия и 10XXXXXXXXXX – Интернет.За да получите 4-цифрения ПИН код изпратете SMS на кратък номер 1590. За мобилна услуга – празен"
				+ " SMS. За Интернет или ТВ – SMS с текст TV или NET и ще получите ПИН кода заедно с всички номера на услуги, които се водят на Ваше име.Ако не сте титуляр на договора за Интернет или ТВ или нямате"
				+ " мобилна услуга, за да разберете ПИН кода и номера на фиксираната услуга, обадете се на *88/123.Ако фактурата Ви включва задължения на повече от една услуга, независимо от това коя ще бъде регистрирана,"
				+ " ще можете да заплатите общата дължима сума за всички услуги.", "^((087|088|089|098)\\d{11}|\\d+)$", "GSM / Абонатен номер и 4 цифри от фактурата слято");
		merchantsListBg.add(mbg);
	}

	public MerchantList getMerchant(String lang) {
		log.info("Start getMerchants: ");
		
		log.info("lang = " + lang);
		if (lang == "bg") {
			return new MerchantList (merchantsListBg.size(), merchantsListBg);
		} else {			
			return new MerchantList (merchantsList.size(), merchantsList);
		}
	}

	public EResponse checkBill(ERequest request) {
		log.info("Start checkBill: ");
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());

		int amount = getRand(1, 200);
		
		EResponse response = getResponse(new EResponse(ResStatus.OK, getDate(), amount, null, null, "", "", "123456789"));	
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
		
		EResponse response = getResponse(new EResponse(ResStatus.OK, getDate(), amount, fee, total, "", "", null));	
	    return response;
	}
	
	public EResponse payBill(ERequest request) {
		log.info("Start payBill: ");
		log.debug("ERequest.getTransactionId - > " + request.getTransactionId());
		log.debug("ERequest.getDt - > " + request.getDt());
		log.debug("ERequest.getAmount -> " + request.getAmount());
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());
		
		return getResponse(new EResponse(ResStatus.OK, null, null, null, null, null, null, null));
	}
	
	public EResponse reverseBill(ERequest request) {
		log.info("Start reverseBill: ");
		log.debug("ERequest.getTransactionId - > " + request.getTransactionId());
		log.debug("ERequest.getDt - > " + request.getDt());
		log.debug("ERequest.getAmount -> " + request.getAmount());
		log.debug("ERequest.getMerchantId - > " + request.getMerchantId());
		log.debug("ERequest.getSubscrNumber - > " + request.getSubscrNumber());
		
		return getResponse(new EResponse(ResStatus.OK, null, null, null, null, null, null, null));
	}
	
	
	public EResponse getResponse(EResponse success) {
		int random = getRand(1, 50);
		
		log.debug("random value: " + random);
		switch (random) {
		case 1:
			throw new EException(ResStatus.NO_PENDING_DUE);
		case 2:
			throw new EException(ResStatus.MERCHANT_REF_NOT_FOUND);
		case 3:
			throw new EException(ResStatus.INVALID_CODE);
		case 4:
			throw new EException(ResStatus.CARD_LOCKED);
		case 5:
			throw new EException(ResStatus.TEMPORARYLY_UNAVL);
		case 6:
			throw new EException(ResStatus.GENERAL_ERROR);
		case 7:
			throw new EException(ResStatus.INVALID_DEPOSIT_AMOUNT);
		case 8:
			throw new EException(ResStatus.INVALID_FORMAT);
		case 9:
			throw new EException(ResStatus.DUE_IS_BLOCKED);
		case 10:
			throw new EException(ResStatus.REPEATED_MESSAGE);
		case 11:
			throw new EException(ResStatus.OLD_DUE_PENDING);
		case 12:
			throw new EException(ResStatus.PERIOD_UNAVL);
		case 13:
			throw new EException(ResStatus.NO_INFO_FOR_MERCHANT_REF_NO);

		default:
			log.debug("End with success");
			return success;
		}
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
}

