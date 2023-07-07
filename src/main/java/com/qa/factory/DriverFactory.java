package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	
	public WebDriver init_driver(String browser) {
		log.info("Browser Selected from config.properties : "+browser);
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				log.info("Chrome driver initiated");
			}else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				log.info("Edge driver initiated");
			}
		}catch(NullPointerException ne) {
			
			log.error(browser + "not initiated ... as the same related set up not done in code level.", ne);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	  	
		return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		return driver;
		
	}
	
}
