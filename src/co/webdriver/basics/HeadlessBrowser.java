package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		//headless browser testing with chrome
		//mandatory options:
		//1. chrome version should be greater than 59 on mac and 60 on winndows
		//2. window-size=1400,800
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless"); 
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		System.out.println("Login page title: "+driver.getTitle());
		
		driver.findElement(By.linkText("Corporate Overview")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Home page Title: "+driver.getTitle());
		
		driver.quit();

	}

}
