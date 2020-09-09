package co.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		
		//1. id - highest priority
		driver.findElement(By.id("u_0_m")).sendKeys("Dhanashree");
		driver.findElement(By.id("u_0_o")).sendKeys("Navarkar");
		
		//2. name - 3rd priority
		driver.findElement(By.name("reg_email__")).sendKeys("navarkardhanashree.gmail.com");
		
		//3. linkText - only for links
		driver.findElement(By.linkText("Forgotten account?")).click();
		driver.navigate().back();
		
		if(title.equals("Facebook – log in or sign up")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		//4. partial link text - not recommended to use- only for links
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//5. css selector
		//if id is there----#{id}
		//if class is there----{class}
		//driver.findElement(By.cssSelector("#u_0_m")).sendKeys("Dhanashree");
		
		//6. classname - not useful
		
		//7. xpath - 2nd priority
		//absolute path should not be used, reetive should be preferred
		
		//8. tagname

		driver.close();

	}

}
