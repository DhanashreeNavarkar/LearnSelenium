package co.testNG.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
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
	
	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("Google Title: "+title);
		
		//Assertion point
		Assert.assertEquals(title, "Facebook", "Title not matched");
		//deliberately failed
	}
	
	@Test
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//span[@class='ctr-p']//center//div//img")).isDisplayed();
		System.out.println("Logo: "+b);
		
		Assert.assertTrue(b);
		Assert.assertEquals(b, true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
