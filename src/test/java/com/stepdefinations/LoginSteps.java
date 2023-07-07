package com.stepdefinations;

import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private ConfigReader configReader =  new ConfigReader();
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private Properties prop = configReader.init_prop();
	
	private static final Logger log = LogManager.getLogger(LoginSteps.class);
	
	@Given("^User is in Login Page of Cogmento CRM$")
	public void userOpenCogmentoCrm() {
		String appurl = prop.getProperty("login_url");
		log.info("Application Url is: "+appurl);
		loginPage.userOpenCogmentoCrm(appurl);
		
	}

	@When("^User enter user Email$")
	public void userEnteUserEmail() {
			String useremail = prop.getProperty("userEmail");
			log.info("User enter Email as :"+useremail);
			loginPage.userEnterEmail(useremail);
	}

	@When("^User enter user Passowrd$")
	public void userEnterUserPassowrd() {
		String userpassword = prop.getProperty("userPassword");
		log.info("User enter password as :"+userpassword);
		loginPage.userEnterPassword(userpassword);	
	}

	@Then("^User click on login button$")
	public void userClickLoginButton() {
		log.info("User clicked on Login button");
	    loginPage.userClickLogin();
	}

	@Then("^Validate the title of the page is \"(.*)\"$")
	public void validateTitleOfLoginPage(String titleloginpage) {
		String actualtitle = loginPage.verifyPageTitle();
		log.info("Expected title is: "+titleloginpage+" and Actual title is "+actualtitle);
		Assert.assertEquals("Expected title is: "+titleloginpage+" but Actual title is "+actualtitle, titleloginpage, actualtitle);
		
	}


}
