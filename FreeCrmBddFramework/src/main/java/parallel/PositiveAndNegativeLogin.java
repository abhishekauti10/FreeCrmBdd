package parallel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PositiveAndNegativeLogin {
	
	WebDriver driver;
	
	@Given("^user is on the the internet page$")
	public void user_is_on_the_the_internet_page(){
		
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); //Users/abhishekauti/Desktop/QA_Softwares/Eclipse/chromedriver-mac-arm64/chromedriver
//		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	

	@When("^title of login page is The Internet$")
	public void title_of_login_page_is_the_internet(){
	    
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("The Internet", title);
	}
	

	@Then("^user enters \"(.*)\" and \"(.*)\"$")					// Using RegEx
	public void user_enters_username_and_password(String username,String password){
		
	     driver.findElement(By.name("username")).sendKeys(username);
	     driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	
	@And("^user clicks on login button first$")
	public void user_clicks_on_login_button_first(){
	    
		driver.findElement(By.tagName("button")).click();
	}
	

	@Then("^user lands on home page$")
	public void user_lands_on_home_page() {
	    
		String title2 = driver.getTitle();
		
		System.out.println("Landing page title : "+ title2);
		
		Assert.assertEquals("The Internet", title2);
		
		driver.quit();
	}
	
	
	@When("^user enters wrong (.*) or (.*)")
	public void user_enters_wrong_username_or_passward(String username,String password) {
		driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}
	
	
	@And("^user clicks on login button second$")
	public void user_clicks_on_login_button_second() {
		driver.findElement(By.tagName("button")).click();
	}
	
	
	@Then("^user login fail with error message at the top$")
	public void user_login_fail_with_error_message_at_the_top() {
		
		String expectedStr1 = "Your username is invalid!\n×";
		
		WebElement errorMessage = driver.findElement(By.id("flash"));

		String actualStr2 = errorMessage.getText();

		Assert.assertEquals(expectedStr1, actualStr2);
		//expectedStr1.equals(actualStr2);
		
		System.out.println("You cannot login as "+ actualStr2);
		
		
		}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//if(scenario.isFailed()) {
		
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(screenshot, "image/png", scenario.getName());
		    
		    
		//}
		
	}
	
	

}
