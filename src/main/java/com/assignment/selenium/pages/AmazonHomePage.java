package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class AmazonHomePage {

	private WebDriver driver;
	public AmazonHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(how = How.XPATH, using ="//*[@type='submit']")
	private WebElement searchBtn;
	
	
	public void searchPhone()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.waitForElement(driver, searchBox);
		searchBox.sendKeys("iPhone XR (64GB) - Yellow");
		searchBtn.click();
	}
}
