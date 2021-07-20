package pages;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class CompanyPage extends BasePage  {

	//constructor
	public CompanyPage (WebDriver driver) {
		super(driver);
	}
	@Step("Search for the leadership section on the Company page")
	//methods
	public boolean searchForSection(String KeyWord) {
		return driver.getPageSource().contains(KeyWord);
	}
	@Step("Get the current URL")
	public String getURL () {
		return driver.getCurrentUrl();
	}
	@Step("Click on the Facebook button")
	public void clickFBButton() {
	
		BasePage.footerElements(3);
		BasePage.switchWindow();
	}
}






