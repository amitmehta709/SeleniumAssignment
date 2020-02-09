package com.assignment.selenium.test;

import org.testng.annotations.Test;

import com.assignment.selenium.pages.AmazonHomePage;
import com.assignment.selenium.pages.AmazonPhoneDetailsPage;
import com.assignment.selenium.pages.FlipkartHomePage;
import com.assignment.selenium.pages.FlipkartPhoneDetailsPage;
import com.assignment.selenium.templates.SeleniumTestTemplate;

public class TC_PhonePriceComparision extends SeleniumTestTemplate {

	@Test
	public void comparePrice()
	{
		getDriver().get("https://www.flipkart.com/");
		FlipkartHomePage homePage = new FlipkartHomePage(getDriver());
		homePage.closePopupIfExist();
		homePage.searchphone();
		
		FlipkartPhoneDetailsPage flipkartPhonePage = new FlipkartPhoneDetailsPage(getDriver());
		String flipKartprice = flipkartPhonePage.getPrice();
		
		int flipkartPrice = Integer.valueOf(flipKartprice.substring(1).replace(",",""));
		
		//System.out.println("FlipkartPrice:"+flipkartPrice);
		
		getDriver().get("https://www.amazon.in/");
		AmazonHomePage amazonHomePage = new AmazonHomePage(getDriver());
		amazonHomePage.searchPhone();
		
		AmazonPhoneDetailsPage amazonPhonePage = new AmazonPhoneDetailsPage(getDriver());
		String amazonpriceVal = amazonPhonePage.getPrice();
		
		int amazonPrice = Integer.valueOf(amazonpriceVal.replace(",",""));
		//System.out.println(amazonPrice);
		
		int minPrice = Math.min(flipkartPrice, amazonPrice);
		
		System.out.println(minPrice);
		
	}
}
