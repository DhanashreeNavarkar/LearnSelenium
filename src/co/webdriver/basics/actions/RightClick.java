package co.webdriver.basics.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		Actions action = new Actions(driver);
		
		WebElement button = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		
		action.contextClick(button).build().perform();
		
		driver.quit();

	}

}
