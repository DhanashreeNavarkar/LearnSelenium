package co.testNG.basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasic {
	
	//Pre conditions annotations- starting with @Before
	
	@BeforeSuite   //1st
	public void setUp() {
		System.out.println("Setup sytem property");
	}
	
	@BeforeTest    //2nd
	public void launchBrowser() {
		System.out.println("Launch chrome browser");
	}
	
	@BeforeClass    //3rd
	public void login() {
		System.out.println("Login");
	}
	
	@BeforeMethod    //4th
	public void enterURL() {
		System.out.println("Enter URL");
	}
	
	//test cases -  staring with @Test
	@Test
	public void googleTitle() {
		System.out.println("Google Title");
	}
	
	@Test
	public void search() {
		System.out.println("Search");
	}
	
	@Test
	public void googleLogo() {
		System.out.println("Google Logo");
	}
	
	//Post conditions - starting with @After
	
	@AfterMethod
	public void logout() {
		System.out.println("LogOut");
	}
	
	@AfterClass  //5th
	public void deleteAllCookies() {
		System.out.println("Delete cookies");
	}
	
	@AfterTest   //6th
	public void close() {
		System.out.println("Close the browser");
	}
	
	@AfterSuite   //7th
	public void report() {
		System.out.println("Generate test reports");
	}

}
