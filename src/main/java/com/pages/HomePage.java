package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import dev.failsafe.internal.util.Assert;

public class HomePage {
	
	private WebDriver driver;
	public HomePage(WebDriver driver) {
	
		this.driver=driver;
	}
	
	// HomePage Elements
	By companyLogo = By.xpath("//div[@class='header item' and contains (@style,'background-image:')]");
	By companyName = By.xpath("//div[@class='header item']/following-sibling::b");
	By userName = By.xpath("//div[@class='right menu']//span[@class='user-display']");
	By accountType = RelativeLocator.with(userName).toLeftOf(By.xpath("//div[@class='right menu']//span[@class='trial-indicator']//a"));
	By searchBox = RelativeLocator.with(accountType).toLeftOf(By.xpath("//div[@class='right menu']//input[@placeholder='Search']"));
	By traseBtn = By.xpath("//div[@class='right menu']//button[@class='ui basic button item']");
	By settingsBtn = By.xpath("//div[@class='right menu']//div[@role='listbox']");
	
	//Default tiles
	By dealSummery = By.xpath("//div[text()='Deals Summary']");
	By deals = By.xpath("//div[text()='Deals']");
	By contactActivityStream = By.xpath("//div[text()='Contacts activity stream']");
	By callQueue = By.xpath("//span[text()='Call Queue']");
	By upcomingCalls = By.xpath("//span[text()='Upcoming calls']");
	By twitter = By.xpath("//div[text()='Twitter']");
	By today = By.xpath("//div[text()='Today']");
	
	//Right side menu icons
	By homePageIcon = By.xpath("//div[@id='main-nav']//div//a[@href='/home']");
	//HomePage Methods
	
	public boolean checkHomePage() {
		return driver.findElement(homePageIcon).isDisplayed();
	}
	
	public boolean validateHomePageHeaders(String headername,String elementtype) {
		boolean linkFound=false;
		if(elementtype.equals("LINK")) {
			
			if(headername.equals("Cogmento")){
				linkFound=driver.findElement(companyLogo).isDisplayed();
			}
			if(headername.equals("SearchBox")) {
				linkFound=driver.findElement(searchBox).isDisplayed();
			}
			if(headername.equals("DeleteIcon")) {
				linkFound=driver.findElement(traseBtn).isDisplayed();
			}
			if(headername.equals("SettingsIcon")) {
				linkFound=driver.findElement(settingsBtn).isDisplayed();
			}
			
		}
		return linkFound;
	}
	
	public boolean validateHomePageHeaders(String headername) {
		boolean isShowing=false;
		String companyActualName=driver.findElement(companyName).getText();
		String userActualName = driver.findElement(userName).getText();
		String accountActualType = driver.findElement(accountType).getText();
		
		if(headername.equals(companyActualName)) {
			isShowing=true;
			
		}
		if(headername.equals(userActualName)) {
			isShowing=true;
			
		}
		if(headername.equals(accountActualType)) {
			isShowing=true;
			
		}
		
		return isShowing;
	}
	
	public boolean validateHomePageDefaultTiles(String tileName) {
		
		boolean isPresent=false;
		String dealsummery=driver.findElement(dealSummery).getText();
		String dealdetails=driver.findElement(deals).getText();
		String contactactivestream = driver.findElement(contactActivityStream).getText();
		String callqueue = driver.findElement(callQueue).getText();
		String upcomingcall = driver.findElement(upcomingCalls).getText();
		String twitterdetail = driver.findElement(twitter).getText();
		String todaydata = driver.findElement(today).getText();

		if(dealsummery.equals(tileName)) {
			isPresent=true;
		}
		if(dealdetails.equals(tileName)) {
			isPresent=true;
		}
		if(contactactivestream.equals(tileName)) {
			isPresent=true;
		}
		if(callqueue.equals(tileName)) {
			isPresent=true;
		}
		if(upcomingcall.equals(tileName)) {
			isPresent=true;
		}
		if(twitterdetail.equals(tileName)) {
			isPresent=true;
		}
		if(todaydata.equals(tileName)) {
			isPresent=true;
		}
		return isPresent;
	}
	

}
