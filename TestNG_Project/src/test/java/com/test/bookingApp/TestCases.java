package com.test.bookingApp;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.RunConfig.browserManager;
import com.aventstack.extentreports.Status;
import com.pom.bookingApp.Home;
import com.pom.bookingApp.ListHotels;

public class TestCases extends browserManager{
	
	private Home home;
	private ListHotels lh;
	
	@Test (priority = 1)
	public void TestCase1() throws InterruptedException {
		SoftAssert sa= new SoftAssert();
		driver.get("https://www.booking.com.");
		
		home=new Home(driver);
		sa.assertEquals(driver.getTitle(), "Find deals on hotels, homes, and much more...");
		test.log(Status.PASS, "Booking app opened successfully and home page displayed: "+driver.getTitle());
		test.log(Status.FAIL, "Booking app failed to open");
		
		home.homeItems("Flight + Hotel");
		Thread.sleep(2000);
		
		home.homeItems("Deny button");
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		home.homeItems("Destination location");
		
		home.homeItems("checkInDate");
		
		home.homeItems("checkOutDate");
		
		home.homeItems("No of ppl button");
		
		home.homeItems("Adults", "2");
		
		home.homeItems("Childrens", "1");
		
		home.homeItems("Age", "5 years old");
		
		home.homeItems("Search button");
		
		sa.assertEquals(driver.getTitle(), "Booking.com: Hotels in Mysore. Book your hotel now!");
	}
	
//	@Test(priority = 2, dependsOnMethods = {"TestCase1"})
//	public void TestCase2() throws InterruptedException {
//		lh=new ListHotels(driver);
//		//lh.ListHotelsItems("Dismiss sign in information button");
//		
//		lh.ListHotelsItems("Very Good CheckBox");
//	}

}
