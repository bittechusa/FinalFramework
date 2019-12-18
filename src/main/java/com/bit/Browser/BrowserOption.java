package com.bit.Browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class BrowserOption {
	//Initialize user name on Browserstack
    public static final String USERNAME = "mamunkhan1";

    //Initialize automated key for Browserstack
    public static final String AUTOMATE_KEY = "kbwsyczq4yoCbwUTxbBb";
  //Initialize url and username and automate key for Browserstack
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	
	public void openBrowserLocally() {
		
		
		
		
		
		
		
	}
	public void openBrowserInGrid() {
		
		
		
		
	}
	 //Function for run test on the Browser Stack
	public void browserStack(WebDriver driver,String browserName) {

        try {

            //Initialize the desired capabilities.
            DesiredCapabilities caps = new DesiredCapabilities();

            //Check the condition for browser open or not.
           // if (!isBrowserOpened)

                //Setting for Firefox browser.
                if (browserName.equalsIgnoreCase("firefox")) {

                    //Log information.
                    //log.info("Browser Stack Open Firefox");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "Firefox");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "32.0");

                    //Set capability for Browser platform.
                    caps.setCapability("os", "Windows");

                    //Set capability for OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Screen size.
                    caps.setCapability("resolution", "2048x1536");

                    //Setting for Chrome browser.
                } else if (browserName.equalsIgnoreCase("chrome")) {

                    //Log information.
                   // log.info("Browser Stack Open Chrome");

                    //Set capability for Browser Name.
                    caps.setCapability("browser", "Chrome");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "38.0");

                    //Set capability for Browser OS.
                    caps.setCapability("os", "Windows");

                    //Set capability for OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Screen size.
                    caps.setCapability("resolution", "2048x1536");

                    //Setting for Safari browser.
                } else if (browserName.equalsIgnoreCase("safari")) {

                    //Log information.
                    //log.info("Browser Stack Open Safari");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "Safari");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "7.0");

                    //Set capability for Browser OS.
                    caps.setCapability("os", "OS X");

                    //Set capability for Browser OS Version.
                    caps.setCapability("os_version", "Mavericks");

                    //Set capability for Browser Screen size.
                    caps.setCapability("resolution", "1920x1080");

                    //Setting for Internet Explorer.
                } else if (browserName.equalsIgnoreCase("IE")) {

                    //Log information.
                    //log.info("Browser Stack Open Internet Explorer");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "IE");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "11");

                    //Set capability for Browse OS.
                    caps.setCapability("os", "Windows");

                    //Set capability for Browse OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Browse  size.
                    caps.setCapability("resolution", "2048x1536");

                }

            try {

                //Initialize the Browser stack Remote address
                driver = new RemoteWebDriver(new URL(URL), caps);

                //If browser is not present, then control will come to catch block.
            } catch (MalformedURLException e) {

                //Print server generate log information.
                e.printStackTrace();
            }

            //Variable returning true.
            //isBrowserOpened = true;

            //Open browser as maximize mode
            driver.manage().window().maximize();

            //Initialize the global time out for entire project -- This line of code will wait 20 second for finding any  web elements.
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //If browser is not present, then control will come to catch block.
        } catch (Exception e) {

            //Initialize the log file
           // log.info("Not able to open browser -  -- " + browserName);

            //Initialize the TestNG fail Assertion.
            Assert.fail(e.getMessage());
        }

    }
}
