package co.testNG.basics;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void login() {
		System.out.println("Login test");
		int i= 9/0;
	}
	
	@Test(dependsOnMethods="login")
	public void home() {
		System.out.println("Home page test");
	}

	
	 @Test (dependsOnMethods="login") 
	 public void search() { 
		 System.out.println("Search test"); 
	  }
	 

}
