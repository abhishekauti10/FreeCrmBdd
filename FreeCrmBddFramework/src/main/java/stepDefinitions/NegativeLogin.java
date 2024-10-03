package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeLogin {
	
WebDriver driver;
	
	@Given("^when user is on the-internet page$")
	public void when_user_is_on_the_internet_page(){
		
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	
	@When("^user enters wrong username or password$")
	public void user_enters_wrong_username_or_password() {
		driver.findElement(By.name("username")).sendKeys("abhishek");
	     driver.findElement(By.name("password")).sendKeys("wrongpass");
	}
	
	@And("^user clicks on login button 2nd$")
	public void user_clicks_on_login_button_2nd() {
		driver.findElement(By.tagName("button")).click();
	}
	
	@Then("^user login fail with error message at the top$")
	public void user_login_fail_with_error_message_at_the_top() {
		
		String expectedStr1 = "Your username is invalid!\n"
				+ "×";
		
		WebElement errorMessage = driver.findElement(By.id("flash"));

		String actualStr2 = errorMessage.getText();

		Assert.assertEquals(expectedStr1, actualStr2);
		//expectedStr1.equals(actualStr2);
		
		System.out.println("You cannot login as "+ actualStr2);
		
		driver.quit();
	}

}
