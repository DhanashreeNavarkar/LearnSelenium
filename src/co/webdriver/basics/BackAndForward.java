package co.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForward {

	public static void main(String[] args) {
	
		//simulation of back and forward
		// to - external site
		// get - launch
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.myntra.com/shop/women");		//get - to launch
		
		String mtitle = driver.getTitle();
		System.out.println("Myntra : "+mtitle);
		
		driver.navigate().to("https://www.amazon.in/");
		String atitle = driver.getTitle();
		System.out.println("Amazon : "+atitle);
		
		if(mtitle.equals("Online Shopping for Women - Shop For Women Clothes, Shoes, Bags & More")) {
			System.out.println("Myntra");
		}else {
			System.out.println("Failed");
		}
		
		driver.navigate().forward();
		if(atitle.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			System.out.println("Amazon");
		}else {
			System.out.println("Failure");
		}
		
		driver.navigate().refresh();
		
		driver.quit();
		

	}

}
