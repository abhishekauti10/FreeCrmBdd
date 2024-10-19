package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksUse{
	
	@Before 
	public void openDriver(){

		System.out.println("Before method");
	}
	
	@Before 
	public void GetUrl(){

		System.out.println("URLLLL");
	}
	
	
	@After 
	public void closeBrowse () {
		
		System.out.println("closeddd");
	}
	
	@After
	public void quitBrowser () {
		
		
		System.out.println("After method");
	}
	

}
