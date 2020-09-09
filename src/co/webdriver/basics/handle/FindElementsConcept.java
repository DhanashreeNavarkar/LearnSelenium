package co.webdriver.basics.handle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//1. get count of links on page
		//2. get text of each link on the page
		
		//tagname is a locator
		// all links are represented by <a> html tags
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		List <WebElement> button = driver.findElements(By.tagName("button"));
		
		//size of linkList
		System.out.println(linkList.size());
		System.out.println(button.size());
		
		for (int i=0; i<linkList.size() ; i++) {
			String link = linkList.get(i).getText();
			System.out.println(link);
		}
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
