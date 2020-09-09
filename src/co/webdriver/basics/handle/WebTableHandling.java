package co.webdriver.basics.handle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		
		//pending
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("navarkardhanashree@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Fcrm@123");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'icon menu sidebar-dark expanded left-to-right')]//a[3]")).click();
		
		//tr - rows
		
		 
		
	}

}
