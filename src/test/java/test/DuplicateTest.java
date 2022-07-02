package test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoriesListPage;
import pages.DashBoardPage;
import util.BrowserFactory;

public class DuplicateTest {
	
	WebDriver driver;
	DashBoardPage dashBoardPage;
	CategoriesListPage categoriesListPage;
	Random rnd = new Random();
	String duplicatedName = "Duplicate Catagory" + rnd.nextInt(99);

	@BeforeMethod
	public void openBrowser() {
		driver = BrowserFactory.initBrowser();
		dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		categoriesListPage = PageFactory.initElements(driver, CategoriesListPage.class);
	}
	
    @Test
    public void userShouldNotBeAbleToAddDuplicateCategory() throws InterruptedException  {
    	dashBoardPage.nameCategory(duplicatedName);
    	dashBoardPage.nameCategory(duplicatedName);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains(text(),'The category you want to add already exists')]"))));
    	
    }
    
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
