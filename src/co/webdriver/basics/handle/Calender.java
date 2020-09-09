package co.webdriver.basics.handle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://msrtc.maharashtra.gov.in/");
		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
		
		String date= "18-September-2021";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		(driver.findElement(By.xpath("//input[@name='journeydate']"))).click();
		
		Select select = new Select(driver.findElement(By.xpath("//select[@class='datepick-new-month']")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.className("datepick-new-year")));
		select1.selectByVisibleText(year);
		
		//div[@class='datepick-one-month datepick-new-row']//tr[1]//td[1]
		//div[@class='datepick-one-month datepick-new-row']//tr[1]//td[2]
		//tr[1]//td[4]//a[1]
		
		String before = "//div[@class='datepick-one-month datepick-new-row']//tr[";
		String after ="]//td[";
		
		final int days=7;
		boolean flag = false;
		
		for (int r = 1; r<=6 ; r++) {
			for (int c = 1; c<= days; c++) {
				String dayVal= driver.findElement(By.xpath(before+r+after+c+"]")).getText();
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
					driver.findElement(By.xpath(before+r+after+c+"]")).click();
					//flag= true;
					//break;
				}
			}
			
			//if(flag=true) {
				//break;
			//}
		}
		
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
