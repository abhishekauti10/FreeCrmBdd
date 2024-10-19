package parallel;


import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/test/java/parallel"}		// Path for feature files or give package name
		,glue= {"parallel"}			// Path for step definition, hooks files or package name
		//,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"rerun:target/Failed.txt"
		}			//extend report
//		,plugin = {"pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "html:target/cucumber-reports/cucumberWebTestreports.html",
//                "rerun:target/cucumber-reports/rerun.txt"			// This shows the additional components in console,
				
//                }			
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		//,tags = ("@RegressionTest or @SmokeTest")
		)	


public class ParallelRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
	

}
