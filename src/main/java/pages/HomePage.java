package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;



public class HomePage extends BasePage  {

	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//ElemntLocators
	private By NameTextField = By.xpath("//input[@name='your-name']");
	private By EmailTextField = By.name("your-email");
	private By SubjectTextField = By.name("your-subject");
	private By MessageTextField = By.name("your-message");
	private By SubmitButton = By.xpath("//input[@value='Send']");
	private By EmailInvalidMessage =
			By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/p[2]/span/span");


	//Methods 
	@Step("Click on Contact us to open Contact us form")
	public void clickContactUS() 
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		BasePage.footerElements(0);

	}
	@Step("Enter Name")
	public void enterName(String Name)
	{

		driver.findElement(NameTextField).clear();
		driver.findElement(NameTextField).sendKeys(Name);
	}
	@Step("Enter Invalid E-mail Address")
	public void enterEmail(String EmailAddress) {
		driver.findElement(EmailTextField).clear();
		driver.findElement(EmailTextField).sendKeys(EmailAddress);
	}
	@Step("Enter text in Subject Field")
	public void enterSubject(String Subject) {
		driver.findElement(SubjectTextField).clear();
		driver.findElement(SubjectTextField).sendKeys(Subject);
	}
	@Step("Enter text in Message Field")
	public void enterMessageText(String Message) {
		driver.findElement(MessageTextField).clear();	
		driver.findElement(MessageTextField).sendKeys(Message);
	}
	@Step("Click Submit")
	public void clickSubmitButton() {
		driver.findElement(SubmitButton).click();
	}
	@Step("Get Error Message for invalid email")
	public String getErrorMessage() {
		BasePage.presenceOfElement(driver, 30, EmailInvalidMessage);
		String TheInvalidMessage = driver.findElement(EmailInvalidMessage).getText();
		return TheInvalidMessage;
	}
	
	@Step("Click on Company tab")
	public void clickCompanyTab() 
	{
		WebElement CompanyTab = 
				driver.findElement(By.xpath("//*[@id='menu-main-nav-1']/li[1]/a"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(CompanyTab));
		Actions action = new Actions(driver);
		action.doubleClick(CompanyTab).perform();
	
	}
	
	@Step("Click on Career tab")
	public  void clickCareerTab()  {
		WebElement CareerTab = 
				driver.findElement(By.xpath("//*[@id='menu-main-nav-1']/li[5]/a"));

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(CareerTab));
		Actions action = new Actions(driver);
		action.click(CareerTab).perform();
	}
}





