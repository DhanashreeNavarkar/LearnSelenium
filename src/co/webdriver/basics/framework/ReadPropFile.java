package co.webdriver.basics.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		
		FileInputStream ip = new FileInputStream("D:\\Setups\\eclipse-workspace\\LearnSelenium\\src\\co\\webdriver\\basics\\framework\\config.properties");
		
		p.load(ip);
		
		System.out.println(p.getProperty("name")); 		//we have commented this property using #
		System.out.println(p.getProperty("age"));
		
		String url = p.getProperty("URL");
		System.out.println(url);
		String browser = p.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		}
		else if(browser.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Setups\\Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		else if(browser.equals("IE")){
			System.setProperty("webdriver.gecko.driver", "D:\\Setups\\Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		    driver = new InternetExplorerDriver();
		}
			
		driver.get(url);
		
		driver.findElement(By.xpath(p.getProperty("firstname_xpath"))).sendKeys(p.getProperty("firstname"));
		driver.findElement(By.xpath(p.getProperty("lastname_xpath"))).sendKeys(p.getProperty("lastname"));
		//driver.findElement(By.xpath(p.getProperty("city_xpath"))).sendKeys(p.getProperty("city"));
		
		driver.quit();
		
		
	}

}
