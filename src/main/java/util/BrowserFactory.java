package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver; 
	 
	public static WebDriver initBrowser() {  
        System.setProperty("webdriver.chrome.driver", "/Users/guest1/Desktop/TechFios/DEC2021/SELENIUM/TestNGAutomationProject/driver/chromedriver");
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://techfios.com/test/102/index.php");
	  
	  return driver;  
	 } 
	
 }