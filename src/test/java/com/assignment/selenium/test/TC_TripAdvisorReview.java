package com.assignment.selenium.test;

import org.testng.annotations.Test;

import com.assignment.selenium.pages.TripAdvisorHomePage;
import com.assignment.selenium.pages.TripAdvisorHotelsPage;
import com.assignment.selenium.pages.TripAdvisorReviewPage;
import com.assignment.selenium.templates.SeleniumTestTemplate;

public class TC_TripAdvisorReview extends SeleniumTestTemplate {

	@Test
	public void reviewTripAdvisor()
	{
		getDriver().get("https://www.tripadvisor.in/");
		
		TripAdvisorHomePage tripHomePage = new TripAdvisorHomePage(getDriver());
		tripHomePage.searchAndClickHotel();
		TripAdvisorHotelsPage hotelPage = new TripAdvisorHotelsPage(getDriver());
		hotelPage.ClickonReview();
		
		TripAdvisorReviewPage reviewPage = new TripAdvisorReviewPage(getDriver());
		reviewPage.providereview();
		
		
	}
}
