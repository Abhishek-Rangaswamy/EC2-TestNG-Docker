package com.test.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class testCaseHelper {

	public String getFutureDate(int daysAhead) {
		LocalDate currentDate =LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(daysAhead);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fdate = futureDate.format(formatter);
		System.out.println("Current date: "+currentDate.toString()+ " and "+ daysAhead+ " days ahead date: "+fdate);
		return fdate;
	}
	
	public void dropDown(WebDriver driver, WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByContainsVisibleText(value);
	}
	
}
