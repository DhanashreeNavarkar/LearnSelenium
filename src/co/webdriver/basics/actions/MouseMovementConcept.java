package co.webdriver.basics.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
	
	//we use this when we need to hover over a web element and then perform action

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://msrtc.maharashtra.gov.in/");
		
		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("About us"))).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Bus Stands / Depots")).click();
		
		driver.quit();

	}

}
