package com.RunConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class setUpReports {
	
	//Responsible for generating the report file (HTML-based).
	public static ExtentSparkReporter sparkReporter;
	//The main reporting engine that manages multiple test logs.
	public static ExtentReports extent;
	//Represents an individual test case in the report.
	public static ExtentTest test;

	@BeforeSuite
	public void generateReport() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date=new Date();
		String filePath=dateFormat.format(date).toString();
		sparkReporter=new ExtentSparkReporter("Reports\\"+"AutomationReport -"+filePath+".html");
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		test=extent.createTest("TestNG - Project");
	}
	
	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
	
}
