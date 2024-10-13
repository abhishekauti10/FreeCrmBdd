package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/main/java/feature/login.feature"}		// Path for feature files or give package name
		,glue= {"stepDefinitions", "MyHooks"}			// Path for step definition, hooks files or package name
		,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/cucumber-reports/rerun.txt"}			// This shows the additional components in console
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		//,tags = {"@SmokeTest , @RegressionTest"}
		)									
public class TestRunner {

}


// OR = tags = {"@SmokeTest , @RegressionTest"}
// AND = tags = {"@SmokeTest" , "@RegressionTest"}
