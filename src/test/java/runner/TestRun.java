package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions
( 		
		//features="classpath:feature",
		features= {"src/test/resources"},
		glue= {"stepdefs"},
		tags= "",
		plugin = {"summary","pretty",
				"html:target/cucumber-reports.html",
				"json:target/json/cucumber-reports"},
				
		dryRun=false,
		monochrome = true
 
		)

public class TestRun {

}
