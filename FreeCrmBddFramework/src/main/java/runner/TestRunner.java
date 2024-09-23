package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/main/java/feature"		// Path for feature files or give package name
		,glue= {"/Users/abhishekauti/git/FreeCrmBdd/FreeCrmBddFramework/src/main/java/steps"}			// Path for step definition files or package name
		)

public class TestRunner {

}
