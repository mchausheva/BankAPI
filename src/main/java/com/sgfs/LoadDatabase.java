//package com.sgfs;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.sgfs.Model.Bill;
//import com.sgfs.Model.Merchant;
//import com.sgfs.Model.Merchant.Type;
//import com.sgfs.repository.BillRepository;
//import com.sgfs.repository.MerchantRepository;
//
//@Configuration
//public class LoadDatabase{
//
//	@Autowired
//	private MerchantRepository merchantRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		Merchant m1 = new Merchant(
//       		"Jonh", "john", "gjk", true, 1, "Cat1",
//       		Type.billing, false, true, "woe", "wferf", "fw", "fwz");
//		Merchant m2 = new Merchant(
//				"Maria", "john", "gjk", false, 2, "Cat2",
//				Type.deposite, true, true, "wee", "wferf", "fw", "fwz");
//		Merchant m3 = new Merchant(
//       		"Jefree", "john", "gjk", true, 3, "Cat3",
//				Type.deposite, false, false, "wfe", "wferf", "fw", "fwz");
//		
//		List<Merchant> merchantsList = Arrays.asList(m1, m2, m3);
//		merchantsList = merchantsList.stream()
//						.collect(Collectors.toList());
//		merchantRepository.saveAll(merchantsList);
//	}
//
//	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//	@Bean
//	CommandLineRunner initDatabase (MerchantRepository merchantRepository, 
//									BillRepository billRepository) {
//		return args -> {           
//			
//			Merchant m1 = new Merchant(
//            		 "Jonh", "john", "gjk", true, 1, "Cat1",
//					 Type.billing, false, true, "woe", "wferf", "fw", "fwz");
//			Bill b1 =  new Bill("2589", "00", LocalDate.of(2010, 10, 17), 100, "", "", "");
//            
//            Merchant m2 = new Merchant(
//            		 "Maria", "john", "gjk", false, 2, "Cat2",
//					 Type.deposite, true, true, "wee", "wferf", "fw", "fwz");
//            Bill b2 = new Bill("3469", "62", LocalDate.of(2015, 11, 21), 100, "", "", "");
//            
//            Merchant m3 = new Merchant(
//            		 "Jefree", "john", "gjk", true, 3, "Cat3",
//					 Type.deposite, false, false, "wfe", "wferf", "fw", "fwz");
//            Bill b3 = new Bill("4856", "52", LocalDate.of(2011, 12, 29), 100, "", "", "");
//            
//            Merchant m4 = new Merchant(
//            		"Josh", "john", "gjk", true, 4, "Cat4",
//            		Type.billing, true, true, "wfe", "wferf", "ffdfh", "fwfz");
//            Bill b4 = new Bill("2589", "00", LocalDate.of(2021, 10, 17), 200, "", "", "");
//            
//            Merchant m5 = new Merchant(
//            		"Joanh", "john", "gjk", true, 5, "Cat5",
//            		Type.deposite, false, false, "wfe", "wferf", "fwg", "fwffz");
//            Bill b5 = new Bill("2589", "00", LocalDate.of(2021, 10, 17), 200, "", "", "");
//			
//			billRepository.saveAll(
//					List.of(b1, b2, b3, b4, b5));
//            merchantRepository.saveAll(
//                    List.of(m1, m2, m3, m4, m5));
//		};
//	}
//}
