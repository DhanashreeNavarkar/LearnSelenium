package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://register.freecrm.com/register/");
		
		//1. isDisplayed() method - applicable for all  elements
		boolean b1 = driver.findElement(By.xpath("//button[@name='action']")).isDisplayed(); //for submit button
		System.out.println(b1);
		
		//2. isEnabled() - primarily used for buttons
		// eg - select i agree checkbox
		boolean b2 = driver.findElement(By.xpath("//button[@name='action']")).isEnabled(); //for submit button
		System.out.println(b2);
		
		//3. isSelected() - only applicable for checkbox , dropdown , radiobutton
		boolean b3 = driver.findElement(By.xpath("//a[contains(text(),'I Agree to the terms and conditions')]")).isSelected();
		System.out.println(b3);
		
		driver.findElement(By.xpath("//a[contains(text(),'I Agree to the terms and conditions')]")).click();
		Thread.sleep(2000);
		
		boolean b4 = driver.findElement(By.xpath("//a[contains(text(),'I Agree to the terms and conditions')]")).isSelected();
		System.out.println(b4);
				
		
		
		driver.quit();
		
	}

}
