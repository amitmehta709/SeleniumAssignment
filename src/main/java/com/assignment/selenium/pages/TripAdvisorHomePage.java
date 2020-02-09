package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.selenium.utils.DriverUtils;

public class TripAdvisorHomePage 
{
	private WebDriver driver;
	public TripAdvisorHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@title='Search']")
	private WebElement searchBox;
	
	@FindBy(how = How.ID, using = "mainSearch")
	private WebElement mainSearch;
	
	@FindBy(how = How.ID, using ="SEARCH_BUTTON")
	private WebElement searchBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='prw_rup prw_search_search_result_poi']//div[@class='location-meta-block']/div[@class='result-title']")
	private WebElement hotelLink;
	
	public void searchAndClickHotel()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.waitForElement(driver, searchBox);
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchBox)).click();

		DriverUtils.waitForElement(driver, searchBox);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(mainSearch)).sendKeys("Club Mahindra");;
	
		DriverUtils.click(driver, searchBtn);
		
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.sleep();
		
		hotelLink.click();
		
		DriverUtils.sleep();
		
		
		
	}
}
