package com.test.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clickActionHelper {

	private WebDriverWait explicitWait;

	/**
	 * @Author Abhishek Rangaswamy
	 * @Description : Click on the element when it is ready
	 * @param driver
	 * @param element
	 */
	public boolean performClick(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			explicitWait.until(ExpectedConditions.elementToBeClickable(element)).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean performClickAndSelect(WebDriver driver, WebElement clickableElement, WebElement option) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			explicitWait.until(ExpectedConditions.elementToBeClickable(clickableElement)).click();
			option.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
