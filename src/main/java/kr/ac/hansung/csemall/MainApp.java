package kr.ac.hansung.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		// 1. Create Spring Container
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");

		// 2. Get Dao Bean
		OfferDao offerDao = (OfferDao)context.getBean("offerDao");
		
		// 3. Call Operation
		System.out.println("The record count is " + offerDao.getRowCount() );
		
		List<Offer> offerList = offerDao.getOffers();  // mapRow method will be called 4 times
		
		for (Offer offer: offerList) {
			System.out.println(offer);  // toString method called
		}
		
		// insert시 id 넣어줄 필요 없음(auto_increment)
		Offer offer = new Offer();
		offer.setName("trudy");
		offer.setEmail("trudy@hanusng.ac.kr");
		offer.setText("Instructor of spring framework");
		
		if ( offerDao.insert(offer) ) {
			System.out.println("Object is inserted successfully");
		}
		else {
			System.out.println("Object insert failed");
		}
		
		// update시 id를 포함해서 다 읽음
		offer = offerDao.getOffer("trudy");
		offer.setName("hyeyeon");
		offer.setEmail("hyeyeon@hansung.ac.kr");
		
		if ( offerDao.update(offer) ) {
			System.out.println("Object is updated successfully");
		}
		else {
			System.out.println("Object update failed");
		}
		
		// delete
		offer = offerDao.getOffer("hyeyeon");
		System.out.println(offer);
		
		if (offerDao.delete(offer.getId()) ) {
			System.out.println("Object is deleted successfully");
		}
		else {
			System.out.println("Object delete failed");
		}
		
		// Close Spring Container
		context.close();
	}

}
