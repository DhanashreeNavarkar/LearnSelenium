package co.webdriver.basics.popups;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		//1. alerts -- JavaScript pop ups -- Alert api(accept, dismiss)
		//2. File Upload -- Browser button (type= file, sendkeys(path))
		//3. Browser window popup -- advertisement  popup (windowHandler api - getWindowHandles()   )
		
		//how to handle window pop-ups
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		//we need window id 
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();	
		
		Thread.sleep(2000);
		
		String parentWindowId = it.next();
		System.out.println("Parent window id: " +parentWindowId);
		
		Thread.sleep(2000);
		
		String childWindowId = it.next();
		System.out.println("Child window id: " +childWindowId);
		
		Thread.sleep(2000);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Chid window title : " +driver.getTitle());
		
		driver.close();		//pop up browser close- use to close specific browser
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title: " +driver.getTitle());
		
		Thread.sleep(2000);			//static wait
		
		driver.quit();					// close all browser


	}

}
