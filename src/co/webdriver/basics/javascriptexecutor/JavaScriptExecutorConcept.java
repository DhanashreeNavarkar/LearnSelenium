package co.webdriver.basics.javascriptexecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys("navarkar@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("gokuldham12");
		//driver.findElement(By.id("u_0_b")).click();
		
		//executeScript --- to execute JavaScript code  
		WebElement login = driver.findElement(By.id("u_0_b"));
		flash(login , driver);		 //highlights the button
		drawBorder( login, driver);		// highlights border - useful for bugs
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Setups\\eclipse-workspace\\screenshots\\login.png"));
		
		//generate alert 
		//generateAlert(driver, "There is an issue with this button");
	
		//click on any elemnent using java script executor
		clickElementByJS( login, driver);;
		
		//refresh using js
		refreshByJS(driver);
		
		//get title
		System.out.println(getTitleByJS(driver));
		
		//get Inner  Text By JS
		System.out.println(getInnerTextByJS(driver));
		
		//for scrolling down
		//scrollPageDown(driver);
		
		WebElement forgotpswd = driver.findElement(By.linkText("Forgotten account?"));
		scrollIntoView(forgotpswd, driver);
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0; i<10; i++) {
			changeColor("rgb(0, 200, 0)" , element , driver);
			changeColor(bgColor, element, driver );
		}
		
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border= '3px solid red '", element);
	}
	
	public static void generateAlert( WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	} 
	
	public static void refreshByJS( WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");	
	}
	
	public static String getTitleByJS( WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();	
		return title;
	}
	
	public static String getInnerTextByJS( WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String innertext= js.executeScript("return document.documentElement.innerText").toString();	
		return innertext;
	}
	
	public static void scrollPageDown( WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView (WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


}
