package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/failed_scenarios.txt",  // Rerun the failed scenarios
    glue = "stepDefinitions",                  
    plugin = {
    		"pretty",
    		"html:target/cucumber-reports-rerun.html"  // Rerun report
    }
)


public class FailedTestRunner {
	
}