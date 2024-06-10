package com.saucelabs.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.saucelabs.utility.ExtentManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;


	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "./myDriver/chromedriver");
		driver = new ChromeDriver();
		//Launching the URL
		driver.get(prop.getProperty("url"));
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();				
	}
	

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
