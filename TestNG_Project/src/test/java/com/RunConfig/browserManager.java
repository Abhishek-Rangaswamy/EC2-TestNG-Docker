package com.RunConfig;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.test.helper.Listener;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener.class)
public class browserManager extends setUpReports {
	
	public static WebDriver driver=null;
	
	@BeforeTest
	@Parameters("browser")
	public void browserLaunch(String browser) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");  // Prevents Selenium detection
	    options.addArguments("--disable-features=ChromeWhatsNewUI");  // Disables Chrome popups
	    options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		Listener.setDriver(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

}
