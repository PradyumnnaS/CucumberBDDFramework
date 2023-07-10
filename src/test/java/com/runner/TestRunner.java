package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/featrues"},
		glue = {"com.stepdefinations","com.apphooks"},
		plugin= {"pretty","html:target/CucumberReport.html"},
	    monochrome = true
	    //dryRun= true
		)
public class TestRunner {
	
}
