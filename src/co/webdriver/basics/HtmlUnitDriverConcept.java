package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		/*
		 * HtmlUnitDriver - is not available in Selenium 3.x version
		 * HtmlUnitDriver- to use this concept we need to download HtmlUnitDriver jar file
		 * 
		 * Advantages:
		 * testing happens behind the scenes, no browser is launched
		 * it is very  fast
		 * not suitable for action class - double click, mouse movement, drag and drop
		 * Also known as host Driver/Headless browser:
		 * 					HtmlUnitDriver- Java
		 * 					PhantomJS- JavaScript
		 */
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		//for page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		//for all the elements
		
		driver.get("https://www.ebay.com/");
		
		System.out.println("Before login : "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Java");
		
		System.out.println("After login : "+driver.getTitle());
		
		Thread.sleep(5000);
		driver.quit();

	}

}
