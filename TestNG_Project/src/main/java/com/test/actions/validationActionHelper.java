package com.test.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class validationActionHelper {
	
	public WebDriverWait explicitWait;

	public boolean verifyElement(WebDriver driver, WebElement ele, String attribute, String expValue) {
		String actValue=ele.getAttribute(attribute);
		if(actValue.equals(expValue)) {
			return true;
		}else {
			return false;
		}
	}
	
}
