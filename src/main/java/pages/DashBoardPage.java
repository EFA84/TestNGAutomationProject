package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashBoardPage {

	WebDriver driver;

	public void DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement catergoryNameField;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement addcategoryButton;
    @FindBy(how = How.CSS, using = "select[name='due_month']")
    WebElement dueMonthsDropdownElement;
	

	public void nameCategory(String categoryName) throws InterruptedException {
		catergoryNameField.sendKeys(categoryName);
		Thread.sleep(1000);
		addcategoryButton.click();
	}
	
	public List<String> getMonthDropdownList() {
        List<String> actualDropdownValues = new ArrayList<String>();
        Select dropdown = new Select(dueMonthsDropdownElement);
        List<WebElement> dropdownValues = dropdown.getOptions();
        for (int i = 0; i < dropdownValues.size(); i++) {
            actualDropdownValues.add(i, dropdownValues.get(i).getText());
        }
        return actualDropdownValues;
    }

	
	
}
