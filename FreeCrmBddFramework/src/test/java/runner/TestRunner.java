package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/test/resources/feature"}		// Path for feature files or give package name
		,glue= {"stepDefinitions"}			// Path for step definition, hooks files or package name
		,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",		//extend report
				"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/failed_scenarios.txt"		// This shows the additional components in console,
                }			
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		,tags = ("@RegressionTest or @SmokeTest")
		)	


public class TestRunner  {
	
	

}


// OR = tags = ("@SmokeTest or @RegressionTest")
// AND = tags = ("@SmokeTest and @RegressionTest")
