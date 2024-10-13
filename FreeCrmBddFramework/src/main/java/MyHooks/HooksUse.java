package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksUse {
	
	@Before (order = 1)
	public void openDriver(){

		System.out.println("Before method");
	}
	
	@Before (order = 2)
	public void GetUrl(){

		System.out.println("URLLLL");
	}
	
	
	@After (order = 2)
	public void closeBrowse () {
		
		System.out.println("closeddd");
	}
	
	@After (order = 1)
	public void quitBrowser () {
		
		System.out.println("After method");
	}
	
	
}
