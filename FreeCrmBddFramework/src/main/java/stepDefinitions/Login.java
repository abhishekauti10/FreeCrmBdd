package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;





public class Login {
	
	WebDriver driver;
	
	//@Test
	@Given("^when user is on the free crm page$")
	public void when_user_is_on_the_free_crm_page(){
		
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); //Users/abhishekauti/Desktop/QA_Softwares/Eclipse/chromedriver-mac-arm64/chromedriver
//		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	//@Test
	@When("^title of login page is The Internet$")
	public void title_of_login_page_is_the_internet(){
	    
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("The Internet", title);
	}
	//@Test
	@Then("^user enters username & password$")
	public void user_enters_username_password(){
		
	     driver.findElement(By.name("username")).sendKeys("tomsmith");
	     driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		
	}
	//@Test
	@And("^user clicks on login button$")
	public void user_clicks_on_login_button(){
	    
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^user lands on home page$")
	public void user_lands_on_home_page() {
	    
		String title2 = driver.getTitle();
		System.out.println("Landing page title : "+ title2);
		
		
		Assert.assertEquals("The Internet", title2);
		
		
		driver.quit();
	}
	
	

}
