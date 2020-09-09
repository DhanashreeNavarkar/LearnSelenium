package co.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("u_0_m")).sendKeys("Dhanashree");
		driver.findElement(By.id("u_0_o")).sendKeys("Navarkar");
		driver.findElement(By.name("reg_email__")).sendKeys("navarkardhanashree.gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Oracle@1108");
		
		// drop down
		Select select = new Select(driver.findElement(By.id("day")));
		select.selectByVisibleText("15");
		Select select1 = new Select(driver.findElement(By.id("month")));
		select1.selectByVisibleText("Jul");
		Select select2 = new Select(driver.findElement(By.id("year")));
		select2.selectByVisibleText("1997");
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		Thread.sleep(5000);
		driver.close();


	}

}
