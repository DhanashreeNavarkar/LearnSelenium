package co.testNG.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test (priority = 1, groups= "Google")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("Google Title: "+title);
	}
	
	@Test (priority = 2, groups="Google")
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//span[@class='ctr-p']//center//div//img")).isDisplayed();
		System.out.println("Logo: "+b);
	}
	
	@Test (priority = 3, groups="Google")
	public void mailLinkTest() {
		boolean b1 = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed();
		System.out.println("Link: "+b1);
	}
	
	@Test  (groups="Test")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test (groups="Test")
	public void test2() {
		System.out.println("Test2");
	}
	
	
	@Test (groups="Test")
	public void test3() {
		System.out.println("Test3");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
