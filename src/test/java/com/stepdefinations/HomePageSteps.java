package com.stepdefinations;


import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {
	
	HomePage homepage = new HomePage(DriverFactory.getDriver());
	private static final Logger log = LogManager.getLogger(LoginSteps.class);
	
	@When("User is in Homepage")
	public void userHomepage() {
		boolean isHomePageIconPresent = homepage.checkHomePage();
		if(isHomePageIconPresent) {
			log.info("User is in Homepage");
		}else {
			log.error("User either not in Homepage or the element changed. Please check once");
			Assert.fail("Homepage icon element not displayed");
		}
	}

	@Then("Validate below homepage header are showing in Homepage")
	public void homePageHeader(DataTable dataTable) {
		
			List<String> homepageHeader=dataTable.asList();
			Iterator<String> itr = homepageHeader.iterator();
			while(itr.hasNext()) {
				log.info("Trying to search Homepage Header :"+itr.next());
				
				if(itr.next().equals("Cogmento") || itr.next().equals("SearchBox") ||
						itr.next().equals("DeleteIcon") ||itr.next().equals("SettingsIcon") ) {			
					boolean isDisplayed=homepage.validateHomePageHeaders(itr.next(), "LINK");
					Assert.assertTrue("Header "+itr.next()+" is not displaying in Homepage", isDisplayed);
				}
				else {
					boolean isShowing=homepage.validateHomePageHeaders(itr.next());
					Assert.assertTrue("Header "+itr.next()+" is not showing in Homepage", isShowing);
				}
			}
	}

	@Then("Validate default tiles are showing in Homepage body")
	public void homepageDetaultTiles(DataTable dataTable) {
		List<String> defaulttilelist = dataTable.asList();
		Iterator<String> itr=defaulttilelist.iterator();
		
		while(itr.hasNext()) {
			log.info("Trying to search Homepage default tile :"+itr.next());
			
			boolean isPresent=homepage.validateHomePageDefaultTiles(itr.next());
			Assert.assertTrue("Tile "+itr.next()+" is not showing in Homepage", isPresent);
		}
	}


}
