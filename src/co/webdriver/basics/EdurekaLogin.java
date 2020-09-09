package co.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EdurekaLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); 	//maximize window
		driver.manage().deleteAllCookies(); 	//delete cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.edureka.co/");
		
		driver.findElement(By.xpath("//a[contains(@class,'login_click login-vd giTrackElementHeader')]")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys("navarkardhanashree@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("edureka@123");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
	

	}

}
