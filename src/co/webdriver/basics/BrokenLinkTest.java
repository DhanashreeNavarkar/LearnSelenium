package co.webdriver.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://makemysushi.com/404?");
		
		//a tag for links
		//img tag for images
		
		//1. get list of all links and images
		
		List <WebElement> list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		System.out.println(list.size());
		
		List <WebElement> activeLink = new ArrayList <WebElement>(); 
		
		//2.iterate list : exclude all images /links which does not have any href attribute
		for (int i=0; i<list.size(); i++ ) {
			System.out.println(list.get(i).getAttribute("href"));
			if(list.get(i).getAttribute("href") != null && (! list.get(i).getAttribute("href").contains("javascript"))) {
				activeLink.add(list.get(i));
			}
		}
		
		//3.get the size of active link list
		System.out.println("Size of active links: "+activeLink.size());
		
		//4. check href url, with http api connection
		
		//200 - ok
		//404 - not found
		//500- internal error
		//400 - bad request
		
		for(int j =0; j<activeLink.size(); j++) {
			
		HttpURLConnection connection = (HttpURLConnection)new URL(activeLink.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String response = connection.getResponseMessage();
		connection.disconnect();
		System.out.println(activeLink.get(j).getAttribute("href")+"------->"+response);
		}
		
		driver.quit();

	}

	}
