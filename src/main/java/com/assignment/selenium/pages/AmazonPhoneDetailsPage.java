package com.assignment.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.selenium.utils.DriverUtils;

public class AmazonPhoneDetailsPage {

	
	
	private WebDriver driver;
	public AmazonPhoneDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	@FindBy(how = How.XPATH, using ="//div[@class='s-result-list s-search-results sg-row']/div[@data-index='0']//div[@class='s-include-content-margin s-border-bottom']/div/div[2]/div[2]//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']/span/span[2]/span[@class='a-price-whole']")
	private WebElement priceLabel;
	
	public String getPrice()
	{
		DriverUtils.waitForPageLoad(driver);
		DriverUtils.sleep();
		String price = priceLabel.getText();
		return price;
	}
	
	
}
