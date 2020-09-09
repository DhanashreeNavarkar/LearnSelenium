package co.webdriver.basics.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait - if page loads in 2 sec remaining 18 sec are ignored
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//implicit wait -is applied globally ie. it is available for all webelement
		//can be changed anywhere and anytime
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		driver.get("https://www.myntra.com");		//get - to launch
		
		WebElement search= driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		
		sendKeys(driver, search, 10, "Steamer");
		
		WebElement searchbtn = driver.findElement(By.xpath("//div[@id='desktop-headerMount']//div[3]//a[1]//span[1]"));
		
		clickOn(driver, searchbtn, 10);
		
		driver.quit();
		
	}
	
	/* Explicit love
	 *  1. no explicit keyword
	 *  2. available with WebDriverWait with some expected conditions
	 *  3. specific to element
	 *  4. dynamic in nature
	 *  5. never use implicit and explicit wait together-
	 *   because selenium webdriver will first apply IMPLICIT and then EXPLICIT wait 
	 *   Hence, sync wait will be increased for each element
	 */
	public static void sendKeys(WebDriver driver, WebElement locator, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
