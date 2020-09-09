package co.webdriver.basics.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		//also known as menu and sub-menu concept

		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://mrbool.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Content')]"))).build().perform();
		
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//span[@id='headermenudesktop']//a[contains(text(),'Courses')]")).click();
		
		 System.out.println(driver.getTitle());
		 driver.quit();

	}

}
