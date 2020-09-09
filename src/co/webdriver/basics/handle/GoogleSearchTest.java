package co.webdriver.basics.handle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless"); 
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	
		System.out.println("1st: "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
		
		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println("Total number of suggestions: "+list.size());
		
		for(int i =0; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().contains("testing life cycle")) {
			list.get(i).click();
			break;
		}
		}
		System.out.println("2nd: "+driver.getTitle());
		
		driver.quit();
		
	}

}
