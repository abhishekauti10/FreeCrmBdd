package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/main/java/feature"}		// Path for feature files or give package name
		,glue= {"stepDefinitions", "MyHooks"}			// Path for step definition, hooks files or package name
		,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/cucumber-reports/rerun.txt"}			// This shows the additional components in console
		,dryRun = true										//True = no actual execution will take place, false = Actual execution will happen
		,tags = ("@RegressionTest or @SmokeTest")
		)									
public class TestRunner {

}


// OR = tags = ("@SmokeTest or @RegressionTest")
// AND = tags = ("@SmokeTest and @RegressionTest")
