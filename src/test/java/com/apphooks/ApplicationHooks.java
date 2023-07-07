package com.apphooks;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader ;
	private Properties prop;
	private static final Logger log = LogManager.getLogger(ApplicationHooks.class);
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		
		prop = configReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver=driverFactory.init_driver(browserName);
			
	} 
	
	@After(order=0)
	public void quitBrowser() {
		log.info("Driver tear down ....");
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//Take  screen shot
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			log.info("Taking Screenshot ...");
			scenario.attach(sourcePath, "image/png", screenshotname);
			
		}
	}
	
}
