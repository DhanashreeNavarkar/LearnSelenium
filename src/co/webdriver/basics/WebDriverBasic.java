package co.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasic {

	public static void main(String[] args) {
		
		//WebDriver - is an interface
		//ChromeDriver - is a class
		//dynamic polymorphism- child class can be refered by  parent class
		WebDriver driver = new ChromeDriver();
		
		WebDriver driver1 = new FirefoxDriver();
		WebDriver driver2 = new InternetExplorerDriver();
		WebDriver driver3 = new SafariDriver();
		
		

	}

}
