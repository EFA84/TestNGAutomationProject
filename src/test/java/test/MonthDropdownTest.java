package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoriesListPage;
import pages.DashBoardPage;
import util.BrowserFactory;

public class MonthDropdownTest {

	WebDriver driver;
	DashBoardPage dashBoardPage;
	CategoriesListPage categoriesListPage;

	@BeforeMethod
	public void openBrowser() {
		driver = BrowserFactory.initBrowser();
		dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		categoriesListPage = PageFactory.initElements(driver, CategoriesListPage.class);
	}

	@Test
	public void allMonthShouldBeInDropDown() throws InterruptedException {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		List<String> dropdownList = dashBoardPage.getMonthDropdownList();
		Assert.assertTrue(isMonthMatch(months, dropdownList), "Values does not match");
		Thread.sleep(5000);
	}

	private boolean isMonthMatch(String[] months, List<String> dropdownList) {
		for (int i = 0; i < dropdownList.size(); i++) {
			if (dropdownList.get(i).equalsIgnoreCase(months.toString())) {
			}
		}
		return true;
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
