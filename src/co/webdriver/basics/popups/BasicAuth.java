package co.webdriver.basics.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//format:--->  //http://username:password@website.com
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String pageMessage= driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		System.out.println(pageMessage);
		
		driver.quit();
		
	}

}
