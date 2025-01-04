package com.qa.factory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	/*
	 * ThradLocal is used for achieving parallel execution 
	 */
	public static ThreadLocal<WebDriver> tlDriver =  new ThreadLocal<>(); 
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	
	public WebDriver init_driver(String browser) {
		log.info("Browser Selected from config.properties : "+browser);
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				/*
				 * Now after Selenium 4.6.0 Selenium manager is there to manage the driver management 
				 * No need of using WebDrivermanager it wil detect browser and chromedriver automatically
				 * Similar CFT(Chrome for Test) a browser specific for selenium testing is present which came from chrome version 115
				 */
				//WebDriverManager.chromedriver().setup(); 
				//driver= new ChromeDriver();
				//ChromeOptions co = new ChromeOptions();
				//co.setBrowserVersion("116");
				//tlDriver.set(new ChromeDriver(co));
				
				tlDriver.set(new ChromeDriver());
				log.info("Chrome driver initiated");
			}else if(browser.equalsIgnoreCase("edge")) {
				//WebDriverManager.edgedriver().setup();
				//driver = new EdgeDriver();
				tlDriver.set(new EdgeDriver());
				log.info("Edge driver initiated");
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				tlDriver.set(new FirefoxDriver());
				log.info("Firefox driver initiated");
			}
		}catch(NullPointerException ne) {
			
			log.error(browser + "not initiated ... as the same related set up not done in code level.", ne);
		}
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  	getDriver().manage().deleteAllCookies();
	  	getDriver().manage().window().maximize();
	  	getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	  	getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return getDriver();
		
	}
	
	public static  WebDriver getDriver() {
		//return driver;
		return tlDriver.get();
		
	}
	
}
