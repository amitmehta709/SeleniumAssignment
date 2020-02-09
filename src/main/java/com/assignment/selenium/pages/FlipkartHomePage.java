package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class FlipkartHomePage {

	private WebDriver driver;
	public FlipkartHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.XPATH, using = "//div/button[@class='_2AkmmA _29YdH8']")
	private WebElement loginPopClose;
	
	@FindBy(how = How.XPATH, using ="//div[@class='O8ZS_U']/input[@type='text']")
	private WebElement searchBar;
	
	@FindBy(how = How.XPATH, using ="//button[@type='submit']")
	private WebElement submitSearch;
	
	public void closePopupIfExist()
	{

		DriverUtils.waitForPageLoad(driver);
		DriverUtils.sleep();
		if(DriverUtils.checkElement(loginPopClose))
		{
			loginPopClose.click();
		}
			
	}
	
	public void searchphone() 
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.waitForElement(driver, searchBar);
		searchBar.sendKeys("iPhone XR (64GB) - Yellow");
		submitSearch.click();
		
	}
	
	
}
