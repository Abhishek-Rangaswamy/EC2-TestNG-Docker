package com.pom.bookingApp;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.actions.clickActionHelper;

public class ListHotels {

	WebDriver driver;
	WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));
	clickActionHelper cah=new clickActionHelper();

	@FindBy(xpath="//div[.='Sign in, save money']")
	private WebElement signInPopUp;

	@FindBy(xpath="//button[@aria-label='Dismiss sign in information.']")
	private WebElement dismissSignInInfo;

	@FindBy(xpath="//label[@for=':r3q:']//span[@class='fcd9eec8fb b27b51da7f bf9a32efa5']//*[name()='svg']")
	private WebElement vGoodChkBox;

	public ListHotels(WebDriver driver) {
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}

	public void ListHotelsItems(String itemName) throws InterruptedException {
		boolean itemOperationSuccess = false;
		switch (itemName) {
//		case "Dismiss sign in information button": 
//		    try {
//		        if (signInPopUp.isDisplayed()) {  // If the element is present and visible
//		            System.out.println(itemName + " displayed");
//		            Thread.sleep(3000);
//		            itemOperationSuccess = cah.performClick(driver, dismissSignInInfo);
//		            if (itemOperationSuccess) {
//		                System.out.println("Clicked on the " + itemName + " item");
//		            } else {
//		                System.out.println(itemName + " not present on the screen");
//		            }
//		        } else {
//		            System.out.println(itemName + " not displayed");
//		        }
//		    } catch (NoSuchElementException e) {  // Handle case when signInPopUp is missing
//		        System.out.println(itemName + " not displayed - Exception occurred: " + e.getMessage());
//		    }
//		    break;



		case "Very Good CheckBox": 
			itemOperationSuccess=cah.performClick(driver, vGoodChkBox);
			if(itemOperationSuccess) {
				System.out.println("Clicked on the "+itemName+" item");
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		default:
			System.out.println("Invalid item name: "+itemName);
		}

		if(itemOperationSuccess) {
			Assert.assertTrue(itemOperationSuccess, itemName+" clicked successfully");
		}else {
			System.out.println(itemName+"not displayed");
		}

	}

}
