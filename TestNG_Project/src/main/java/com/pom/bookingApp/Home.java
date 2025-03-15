package com.pom.bookingApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.actions.clickActionHelper;
import com.test.actions.validationActionHelper;
import com.test.helper.testCaseHelper;

public class Home {

	WebDriver driver;
	clickActionHelper cah=new clickActionHelper();
	WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));
	testCaseHelper tch=new testCaseHelper();
	validationActionHelper vah=new validationActionHelper();

	@FindBy(xpath="//button[text()='Deny all']")
	private WebElement denyBtn;

	@FindBy(xpath="//span[text()='Flight + Hotel']")
	private WebElement flightHotel;

	@FindBy(xpath="//input[@placeholder='Where are you going?']")
	private WebElement destinationLocation;

	@FindBy(xpath="//div[text()='Mysore']/..//ancestor::li[@id='autocomplete-result-3']")
	private WebElement option_Mysore;

	@FindBy(xpath="//button[@data-testid='occupancy-config']")
	private WebElement selectNoOfPplBtn;

	@FindBy(xpath="//label[text()='Adults']//ancestor::div[@class='a7a72174b8']//input")
	private WebElement adultsCount;

	@FindBy(xpath="//label[text()='Children']//ancestor::div[@class='a7a72174b8']//input")
	private WebElement childrensCount;

	@FindBy(xpath="//label[text()='Children']//ancestor::div[@class='a7a72174b8']//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 bb803d8689 f4d78af12a']")
	private WebElement clickPlus;

	@FindBy(xpath="//select[@name='age']")
	private WebElement age;

	@FindBy(xpath="//button//span[text()='Done']")
	private WebElement doneBtn;

	@FindBy(xpath="//span[text()='Search']")
	private WebElement searchBtn;

	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void homeItems(String itemName) {
		boolean itemOperationSuccess = false;
		switch (itemName) {

		case "Flight + Hotel":
			itemOperationSuccess=cah.performClick(driver, flightHotel);
			if(itemOperationSuccess) {
				System.out.println("Clicked on the "+itemName+" item");
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		case "Deny button":
			itemOperationSuccess=cah.performClick(driver, denyBtn);
			if(itemOperationSuccess) {
				System.out.println("Clicked on the "+itemName+" item");
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		case "Destination location":
			itemOperationSuccess=cah.performClickAndSelect(driver, destinationLocation, option_Mysore);
			if(itemOperationSuccess) {
				System.out.println("Destination location selected");
			}else {
				System.out.println(itemName+" element not present on the screen");
			}
			break;

		case "checkInDate":
			String checkInDateXpath="//td[@role='gridcell']//span[@data-date='"+tch.getFutureDate(10)+"']";
			WebElement checkInDate=driver.findElement(By.xpath(checkInDateXpath));
			itemOperationSuccess=cah.performClick(driver, checkInDate);
			if(itemOperationSuccess) {
				System.out.println("Selected the "+itemName);
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		case "checkOutDate":
			String checkOutDateXpath="//td[@role='gridcell']//span[@data-date='"+tch.getFutureDate(15)+"']";
			WebElement checkOutDate=driver.findElement(By.xpath(checkOutDateXpath));
			itemOperationSuccess=cah.performClick(driver, checkOutDate);
			if(itemOperationSuccess) {
				System.out.println("Selected the "+itemName);
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		case "No of ppl button":
			itemOperationSuccess=cah.performClick(driver, selectNoOfPplBtn);
			if(itemOperationSuccess) {
				System.out.println(itemName+" clicked sucessfully");
			}else {
				System.out.println(itemName+" element not present on the screen");
			}
			break;

		case "Done button":
			itemOperationSuccess=cah.performClick(driver, doneBtn);
			if(itemOperationSuccess) {
				System.out.println("Clicked on the "+itemName+" item");
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		case "Search button":
			itemOperationSuccess=cah.performClick(driver, searchBtn);
			if(itemOperationSuccess) {
				System.out.println("Clicked on the "+itemName+" item");
			}else {
				System.out.println(itemName+" not present on the screen");
			}
			break;

		default:
			System.out.println("Invalid item name: "+itemName);
		}	

		Assert.assertTrue(itemOperationSuccess, itemName+" clicked successfully");
	}

	public void homeItems(String itemName, String itemValue) {
		boolean itemOperationSuccess = false;

		switch(itemName) {

		case "Adults":
			itemOperationSuccess=vah.verifyElement(driver, adultsCount, "value", itemValue);
			if(itemOperationSuccess) {
				System.out.println("Count of adults: "+itemValue);
			}else {
				System.out.println(itemName+" element not present on the screen");
			}
			break;

		case "Childrens":
			itemOperationSuccess=vah.verifyElement(driver, childrensCount, "value", itemValue);
			if(itemOperationSuccess) {
				System.out.println("Count of childrens: "+itemValue);
			}else {
				if(Integer.parseInt(childrensCount.getAttribute("value"))==0) {
					clickPlus.click();
					System.out.println("Count of childrens: "+itemValue);
					itemOperationSuccess=true;
				}else {
					System.out.println(itemName+" element not present on the screen");
				}
			}
			break;

		case "Age":
			tch.dropDown(driver, age, itemValue);
			itemOperationSuccess=true;
			break;

		default:
			System.out.println("Invalid item name: "+itemName);
		}
		Assert.assertEquals(itemOperationSuccess, true, "Actual result and expected result not matching;");
	}

}
