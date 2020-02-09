package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class FlipkartPhoneDetailsPage 
{
	private WebDriver driver;
	public FlipkartPhoneDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1HmYoV _35HD7C'][2]//div[@class='bhgxx2 col-12-12'][1]//a[@class='_31qSD5']/div[2]/div[2]/div/div/div")
	private WebElement phonePricelabel;
	
	public String getPrice()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.sleep();
		String price = phonePricelabel.getText();
		return price;
	}
	

}
