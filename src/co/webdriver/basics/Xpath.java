package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input=[@id='gh-ac']")).sendKeys("Java"); - not working
		
		//when dynamic id is getting changed use contains 
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Java");
		
		/*
		 * id=test_123 , id = test_456 i.e. value are dynamic
		 * use contains or starts-with
		 * driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendkeys("Java");
		 * 
		 * when id is weird or long i.e. id = test_test_123_456
		 * driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendkeys("Java");
		 * 
		 * id = 1234_test_t or id = 37458_test_t , use contains or ends-with
		 * driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendkeys("Java");
		 */
		
		//for links : custom xpath
		// all links are represented by <a> html tags
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		
		//absolute xpath -not reliable
		//1.  performance issue
		//2.  not reliable
		//3.  can be changed at any time
		
		Thread.sleep(3000);
		driver.quit();


	}

}
