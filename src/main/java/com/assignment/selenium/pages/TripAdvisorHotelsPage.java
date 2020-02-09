package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class TripAdvisorHotelsPage {
	
	private WebDriver driver;
	public TripAdvisorHotelsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Write a review']")
	private WebElement reviewButton;
	
	@FindBy(how = How.XPATH, using = "//div[@data-tab='TABS_REVIEWS']")
	private WebElement reviewTab;
	public void ClickonReview()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.switchtoWindow(driver);
		
		DriverUtils.waitForElement(driver, reviewButton);
		DriverUtils.scrollDown(driver, reviewTab);
		
		reviewButton.click();
		DriverUtils.sleep();
	}
}
