package com.assignment.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class TripAdvisorReviewPage {

	
	private WebDriver driver;
	public TripAdvisorReviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.ID, using = "ReviewTitle")
	private WebElement reviewTitle;
	
	@FindBy(how = How.ID, using = "ReviewText")
	private WebElement reviewText;
		
	@FindBy(how = How.XPATH, using = "//span[@id='bubble_rating']")
	private WebElement bubbleRating;
	
	@FindBy(how = How.ID, using = "noFraud")
	private WebElement noFraudCheckbox;
	
	
	
	public void providereview()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.switchtoWindow(driver);
		
		DriverUtils.waitForElement(driver, bubbleRating);
		
		//Performing Mouse Hover
		performMouseHover(bubbleRating);
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	    jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", bubbleRating, "class", "ui_bubble_rating fl bubble_50");
		
	    DriverUtils.sleep();
	    
		DriverUtils.waitForElement(driver, reviewTitle);
		reviewTitle.sendKeys("My Review Title");
		
		DriverUtils.waitForElement(driver, reviewText);
		reviewText.sendKeys("This is my Review");
		
		DriverUtils.scrollDown(driver, noFraudCheckbox);
		DriverUtils.click(driver, noFraudCheckbox);
		DriverUtils.sleep();
		
	}
	
	private void performMouseHover(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		DriverUtils.sleep();
	}
}
