package com.assignment.selenium.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils 
{
	private static long wait =60;


	public static boolean switchtoWindow(WebDriver driver) {
		for (String handle1 : driver.getWindowHandles()) {

			driver.switchTo().window(handle1);
		}
		return true;
	}
	
	public static void waitForPageLoad(WebDriver driver) {

		new WebDriverWait(driver, wait).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}
	

	public static void waitForElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, wait, 1000).until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
				ExpectedConditions.elementToBeClickable(element)));
	}

	public static void click(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Ignore
		}
	}
	
	public static void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static boolean checkElement(WebElement element)
	{
		try 
		{
			element.isDisplayed();
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}

}
