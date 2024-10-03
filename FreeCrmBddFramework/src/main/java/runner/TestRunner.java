package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/main/java/feature/login.feature"}		// Path for feature files or give package name
		,glue= {"stepDefinitions"}			// Path for step definition files or package name
		,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-web-Testreports.html",
                "rerun:target/cucumber-reports/rerun.txt"}
		)									// This shows the additional components in console

public class TestRunner {

}
