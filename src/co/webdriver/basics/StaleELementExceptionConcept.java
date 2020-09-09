package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleELementExceptionConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		//use breakpoints
		//check system generated id by hovering over the element
		//try refreshing 
		//if id changes - StaleELementException occurs Concept 
	
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize(); 	//maximize window
		driver.manage().deleteAllCookies(); 	//delete cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		driver.get("https://www.edureka.co/");
		
		driver.findElement(By.xpath("//html//body//header//nav//ul//li//a[contains(text(),'Log In')]")).click();
		WebElement e1 = driver.findElement(By.id("si_popup_email"));
		e1.sendKeys("navarkardhanashree@gmail.com");
		WebElement e2 = driver.findElement(By.id("si_popup_passwd"));
		e2.sendKeys("edureka@123");
		//driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

	}

}
