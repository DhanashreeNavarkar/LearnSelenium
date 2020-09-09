package co.webdriver.basics.handle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdowns {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.jqueryfaqs.com/demos/112/");
		
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		
		List <WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		System.out.println(list.size());
		
		//for selecting specfic element
		
//		for(int i= 0; i<list.size();i++){
//			System.out.println(list.get(i).getText());
//			
//			if(list.get(i).getText().contains("Banana")) {
//				list.get(i).click();
//				break;
//			}
//		}
		
		//for select all
		
		for(int i= 0; i<list.size();i++){
			System.out.println(list.get(i).getText());
			list.get(i).click();
		}
		
		
		driver.quit();
		 
		

	}

}
