package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class ExperiencedAutomationQAEngineerPage extends BasePage {

	//Constructor
	public ExperiencedAutomationQAEngineerPage(WebDriver driver) {
		super(driver);
	}

	//ElementLocators
	private By ApplyButton = By.xpath("//input[@value='Apply']");
	private By MyNameTextField =By.cssSelector("#cf-1");
	private By EmailTextField =By.xpath("//*[@id='cf-2']");
	private By UploadFileField =By.xpath("//*[@id='uploadtextfield']");
	private By SendButton      = By.xpath("//input[@type='submit']");
	private By InvalidemailMessage = By.xpath("//*[@id=\"wpcf7-f880-o1\"]/form/p[3]/span/span");

	//Methods
	@Step("Verify that the page contains: Requirements-General Description-Responsibilities-What we offer")
	public boolean verifyPageContains() {
		if(driver.getPageSource().contains("Requirements")
				&& driver.getPageSource().contains("General description") 
				&& driver.getPageSource().contains("Responsibilities")
				&& driver.getPageSource().contains("What we offer"))
		{return  true ;}
		else 
		{return false;}
	}
	@Step("Click on Apply button")
	public void clickApplyButton() {
		driver.findElement(ApplyButton).click();
	}
	@Step("Enter invalid name format in Name field")
	public void enteringInvalidName(String InvalidName) {
		BasePage.switchWindow();
		driver.findElement(MyNameTextField).clear();
		driver.findElement(MyNameTextField).sendKeys(InvalidName);	
	}
	@Step("Enter invalid email format in Email field")
	public void enterInvalidEmail(String InvalidEmail) {
		BasePage.switchWindow();
		driver.findElement(EmailTextField).clear();
		driver.findElement(EmailTextField).sendKeys(InvalidEmail);
	}
	@Step("Upload CV file")
	public void uploadCV(String FilePath) {
		BasePage.switchWindow();
		driver.findElement(UploadFileField).sendKeys(FilePath);
	}
	@Step("Click Send Button")
	public void clickSendButton() {
		BasePage.switchWindow();
		driver.findElement(SendButton).click();
	}

	
	@Step("Get Error Message for invalid email")
	public String getErrorMessage() {
		BasePage.switchWindow();
		BasePage.presenceOfElement(driver, 30, InvalidemailMessage);
		String TheInvalidMessage = driver.findElement(InvalidemailMessage).getText();
		return TheInvalidMessage;
	}
	@Step("Verify that Apply button is present")
	public boolean applyButtonIsPresented() {
		return driver.findElement(ApplyButton).isDisplayed();
	}
}
