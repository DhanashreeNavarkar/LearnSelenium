package co.webdriver.basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/shop/women");
		takeScreenshot("Myntra");
		
		driver.quit();

	}
	
	public static void takeScreenshot(String fileName) throws IOException {
		
		//1. Take screenshot and store it as file format
		File file =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//2. Copy the screenshot  to desired location using copy file  method
		FileUtils.copyFile(file, new File("D:\\Setups\\eclipse-workspace\\screenshots\\"+fileName+".jpg"));
		
	}

}
