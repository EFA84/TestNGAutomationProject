package test;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoriesListPage;
import pages.DashBoardPage;
import util.BrowserFactory;

public class AddCatagoryTest {
	
	WebDriver driver;
	
	DashBoardPage dashBoardPage;
	CategoriesListPage categoriesListPage;
	Random rnd = new Random();
	String categoryName = "Test Category" + rnd.nextInt(99);

	@BeforeMethod
	public void openBrowser() {
		driver = BrowserFactory.initBrowser();
		dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		categoriesListPage = PageFactory.initElements(driver, CategoriesListPage.class);
	}

	@Test
	public void ShouldBeAbletoAddCategory() throws InterruptedException {
		dashBoardPage.nameCategory(categoryName);
		List<String> actualList = categoriesListPage.getListOf();
		Assert.assertTrue(isDataThere(categoryName, actualList), "New Category Isnt There");
	}

	private boolean isDataThere(String categoryName, List<String> actualList) {
		for (int i = 0; i < actualList.size(); i++) {
			if (categoryName.equalsIgnoreCase(actualList.get(i)))
				;
		}
		return true;
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
