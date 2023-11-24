package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith (Cucumber.class)

@CucumberOptions(
		features={"src/test/java/features"}, 
		glue={"stepDefinitions"}, 
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports/index.html", "junit:target/cucumber-reports/report.xml" },
		monochrome=true
		)

public class CucumberRunner {

}

