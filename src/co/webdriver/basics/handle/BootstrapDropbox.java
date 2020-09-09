package co.webdriver.basics.handle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropbox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://getbootstrap.com/docs/4.1/components/dropdowns/");
		
		driver.findElement(By.id("dropdownMenuLink")).click();
		
		List <WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		System.out.println(list.size());
		
		for( int i =0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
				
			}
		}
		
		driver.quit();
	}

}
