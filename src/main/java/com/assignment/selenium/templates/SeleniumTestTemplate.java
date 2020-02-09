package com.assignment.selenium.templates;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestTemplate 
{
	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setupDriver()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(constructChromeOptions());
		
		// maximize the window
		driver.manage().window().maximize();
		// add implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		// clean cookies
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	private static ChromeOptions constructChromeOptions()
	{ 
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		return options;
		
	}

}
