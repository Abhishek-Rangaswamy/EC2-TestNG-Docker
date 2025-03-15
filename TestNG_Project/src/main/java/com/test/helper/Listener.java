package com.test.helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	private static WebDriver driver;

	public static void setDriver(WebDriver webdriver) {
		driver=webdriver;
	}
	
	@Override
	public void onStart(ITestContext context) {
		String browser=context.getCurrentXmlTest().getParameter("browser");
	    System.out.println("Test suite started on browser: "+browser);
	  }

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureScreenShot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test executed successfully: "+result.getName());
	}

	public void captureScreenShot(String testName) throws IOException {
		try {
			File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("screenShots\\"+testName+".png");
			FileHandler.copy(screenShot, destination);
			System.out.println("Screenshot taken: " + destination.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
