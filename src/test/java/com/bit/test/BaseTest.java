package com.bit.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.bit.util.*;

public class BaseTest {
	static ExtentReports report;
	static ExtentTest test;
	Logger log;
	Properties prop;
	
	@BeforeSuite(groups= {"ui","backend"})
	public static void startTest()
	
	{
	
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	
	test = report.startTest("ExtentDemo");
	
	}
	@BeforeTest(groups= {"ui","backend"})
	public void beforeTest() {
		DOMConfigurator.configure("log4j.xml");
		log = Logger.getLogger(BaseTest.class);
		
		prop = Helper.readPropertyFile("/Users/bittech/eclipse-workspace/SeleniumAdvance/config.properties");
		log.info("property file initialized");
		log.info("log file initialized");

		
		log.info("logger instance initialized");

	}
	@BeforeClass(enabled=false,groups= {"ui","backend"})
	
	public void beforeclass(WebDriver driver) throws MalformedURLException {
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("runMode"));
		if (prop.getProperty("browser").equals("chrome")) {
			if(prop.getProperty("runMode").equals("local"))
			{
			driver = new ChromeDriver();
			log.info("chromeDriver initialized");
			}else if(prop.getProperty("run").equals("remote"))
			{
				System.out.println(1);
				DesiredCapabilities cap=new  DesiredCapabilities().chrome();
				System.out.println(2);
				cap.setPlatform(Platform.MAC);
				cap.setBrowserName("chrome");
				//cap.setVersion("");
				ChromeOptions c=new ChromeOptions();
				c.merge(cap);
				System.out.println(3);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), c);
				System.out.println(4);
			}

		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFoxDriver initialized");

		}
		driver.get(prop.getProperty("url"));
		log.info("Navigate to url");

		
	}
	@BeforeMethod(enabled=true)
	public void beforeMethod(WebDriver driver) throws MalformedURLException {
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("runMode"));
		if (prop.getProperty("browser").equals("chrome")) {
			if(prop.getProperty("runMode").equals("local"))
			{
			driver = new ChromeDriver();
			log.info("chromeDriver initialized");
			}else if(prop.getProperty("run").equals("remote"))
			{
				System.out.println(1);
				DesiredCapabilities cap=new  DesiredCapabilities().chrome();
				System.out.println(2);
				cap.setPlatform(Platform.MAC);
				cap.setBrowserName("chrome");
				//cap.setVersion("");
				ChromeOptions c=new ChromeOptions();
				c.merge(cap);
				System.out.println(3);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), c);
				System.out.println(4);
			}

		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFoxDriver initialized");

		}
		driver.get(prop.getProperty("url"));
		log.info("Navigate to url");

		
	}
	@AfterMethod
public void AfterMethod() {
		//close Browser if browser open in before method
		//take ScreenShot if test case fail
		
	}
	@AfterClass
public void AfterClass() {
		//close Browser if browser open in before class
		
	}
	@AfterTest
	public void AfterTest() {
		// close instance of log4j and Properties
		
	}
	@AfterSuite
	public void AfterSuite() {
		//// close instance of extent Report
		
	}


}
