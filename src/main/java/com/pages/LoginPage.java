package com.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

public class LoginPage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	// BY Locator
	By userEmailBox = By.xpath("//input[@name='email']");
	By userPasswordBox = By.xpath("//input[@name='password']");
	By userLoginBtn = By.xpath("//div[contains(text(),'Login')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page action methods
	public void userOpenCogmentoCrm(String url) {
		driver.get(url);
	}
	
	public void userEnterEmail(String email) {
			driver.findElement(userEmailBox).sendKeys(email);
		
	}
	
    public void userEnterPassword(String password) {
		driver.findElement(userPasswordBox).sendKeys(password);
	}
	
    public void userClickLogin() {
		driver.findElement(userLoginBtn).click();
	}
     
    public String verifyPageTitle() {
    	return driver.getTitle();
	}
}
