package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import pages.CareerPage;
import pages.ExperiencedAutomationQAEngineerPage;
import pages.HomePage;
import pages.JoinUsPage;
import utilities.PropertyManager;

public class TestCase3 extends BaseTest{

	private	String CVFilePath = PropertyManager.getInstance().getCVfilePath();
	private	String currentDir = System.getProperty("user.dir");
	private HomePage homePage;
	private CareerPage careerPage;
	private JoinUsPage joinUsPage;
	private ExperiencedAutomationQAEngineerPage experiencedAutomationQAEngineerPage;


	@Test(priority=0,description="Verify correct URL of JoinUs page" )
	@Description("Verify that the correct URL of the JoinUs page loads after clicking Check our open positions button ")
	@Epic("Musalasoft TestCase3")
	public void verifyJoinUsPageURL() {

		homePage.clickCareerTab();
		careerPage.clickOpenPositions();

		Assert.assertEquals(joinUsPage.getCurrentURL(), "https://www.musala.com/careers/join-us/");   
	}


	@Test(priority=1,description="Verify main sections are shown on an open position's page" )
	@Description("Verify the following sections are shown: General Description, Requirements, Responsibilities,What we offer")
	@Epic("Musalasoft TestCase3")
	
	public void verifySectionsAreShown()

	{   	
		homePage.clickCareerTab();
		careerPage.clickOpenPositions();
		joinUsPage.chooseFromDropDownList();
		joinUsPage.clickExperiencedAutomationQAEngineer();;

		Assert.assertTrue(experiencedAutomationQAEngineerPage.verifyPageContains());
	}

	@Test(priority=2,description="Verify apply button is present" )
	@Description("Verify that the apply button is present on an open position page")
	@Epic("Musalasoft TestCase3")
	public void verifyApplyButtonIsPresent()
	{   
		homePage.clickCareerTab();
		careerPage.clickOpenPositions();
		joinUsPage.chooseFromDropDownList();
		joinUsPage.clickExperiencedAutomationQAEngineer();
		Assert.assertTrue(experiencedAutomationQAEngineerPage.applyButtonIsPresented());
	}

	@Test(priority=3,description="Verify Error message is shown for invalid data on Job application" )
	@Description("Verify that entering invalid data in Job application form returns error message")
	@Epic("Musalasoft TestCase3")
	public void verifyApplyErrorMessageIsShown()
	{   
		homePage.clickCareerTab();
		careerPage.clickOpenPositions();
		joinUsPage.chooseFromDropDownList();
		joinUsPage.clickExperiencedAutomationQAEngineer();
		experiencedAutomationQAEngineerPage.clickApplyButton();
		experiencedAutomationQAEngineerPage.enterInvalidEmail("test@test");
		experiencedAutomationQAEngineerPage.uploadCV(currentDir +CVFilePath );
		experiencedAutomationQAEngineerPage.clickSendButton();
		Assert.assertEquals(experiencedAutomationQAEngineerPage.getErrorMessage(),
				"The e-mail address entered is invalid.");
	}

	@BeforeMethod
	public void setup() {
		if (PropertyManager.getInstance().getbrowser().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (PropertyManager.getInstance().getbrowser().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		homePage = new HomePage(driver);
		careerPage = new CareerPage(driver);
		joinUsPage = new JoinUsPage(driver);
		experiencedAutomationQAEngineerPage= new ExperiencedAutomationQAEngineerPage(driver);

		driver.navigate().to(BaseTest.baseURL);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void teardown () {
		driver.quit();
	}
}



