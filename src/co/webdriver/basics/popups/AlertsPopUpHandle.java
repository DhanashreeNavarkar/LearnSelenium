package co.webdriver.basics.popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
	
		//handle the pop up
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String text = alert.getText();
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Correct message");
		}else
		{
			System.out.println("Incorrect message");
		}
		alert.accept(); // click on ok button
		//if cancel button available 
		//alert.dismiss();
		Thread.sleep(2000);
		
		driver.quit();

	}

}
