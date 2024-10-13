package stepDefinitions;


import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqaPositiveForm {

	WebDriver driver;
	
	@Given("user is on the demoqa form page")
	public void user_is_on_the_demoqa_form_page(){
		
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(option);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
		driver.get("https://demoqa.com/automation-practice-form");
		
	}
	
	@When("where page title is title is DEMOQA")
	public void where_page_title_is_title_is_DEMOQA(){
	    
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("DEMOQA", title);
	}
	
	@Then("^user enters the mandatory \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\"$")
	public void user_enters_the_mandatory_and(String fName, String lName, String email, String mobileN) {
	    
		driver.findElement(By.id("firstName")).sendKeys(fName);
	    driver.findElement(By.id("lastName")).sendKeys(lName);
	    driver.findElement(By.id("userEmail")).sendKeys(email);
	    driver.findElement(By.id("userNumber")).sendKeys(mobileN);
	     
	}
	
	@Then("^selects their \"(.*)\"$")
	public void selects_their(String gender) {
	    
		driver.findElement(By.cssSelector(gender)).click();
	}
	
	@And("clicks on submit button")
	public void clicks_on_submit_button() {
	    
		//driver.findElement(By.id("submit")).click();
		
		try {
		     driver.findElement(By.id("submit")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		  }
	}
	

	@Then("user will see pop-up containig their submitted info")
	public void user_will_see_pop_up_containig_their_submitted_info() {
	    
		String expectedSucsMsg = "Thanks for submitting the form";
		
		WebElement formSubmitSuccessPopUpMsg = driver.findElement(By.id("example-modal-sizes-title-lg"));

		String actualSucsMsg = formSubmitSuccessPopUpMsg.getText();

		Assert.assertEquals(actualSucsMsg, expectedSucsMsg);
		
		System.out.println("All your details are noted so "+ actualSucsMsg);
		
		driver.quit();
	}

}
