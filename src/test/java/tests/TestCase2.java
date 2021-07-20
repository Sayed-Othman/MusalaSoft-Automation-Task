package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import pages.CompanyPage;
import pages.HomePage;
import pages.MusalaFaceBookPage;
import utilities.AllureListener;
import utilities.PropertyManager;

@Listeners({AllureListener.class})

public class TestCase2 extends BaseTest {
	
	private HomePage homePage;
	private CompanyPage companyPage ; 
	private MusalaFaceBookPage musalaFaceBookPage;
	String SearchingkeyWord = "Leadership";
	

	@Test(priority=0,description="Verify correct URL of company page" )
	@Description("Verify that the correct URL of the company page loads after clicking Company tab")
	@Epic ("Musalasoft TestCase2")
	public void verifyCompanyPageURL() throws InterruptedException 
	{
		
		homePage.clickCompanyTab();
		Assert.assertEquals(companyPage.getURL(),"https://www.musala.com/company/"); 
	}

	@Test(priority=1,description="Verify the presence of Leadership section")
	@Description("Verify that the company page contains the Leadership section")
	@Epic ("Musalasoft TestCase2")
	public void verifyLeadershipSection() 
	{
		homePage.clickCompanyTab();
		Assert.assertTrue(companyPage.searchForSection(SearchingkeyWord));
	}

	@Test(priority=2,description="Verify correct URL of Facebook page")
	@Description("Verify that the correct URL of the Facebook page loads after clicking Facebook button")
	@Epic ("Musalasoft TestCase2")
	public void verifyFBURL() 
	{

		homePage.clickCompanyTab();
		companyPage.clickFBButton();
		Assert.assertEquals( musalaFaceBookPage.getURL(), "https://www.facebook.com/MusalaSoft?fref=ts"); 
	}

	@Test(priority=3,description="Verify profile picture on Facebook page")
	@Description("Verify that the profile picture appears on Facebook page")
	@Epic ("Musalasoft TestCase2")
	public void verifyProfileImgIsDisplayed() 
	{
		homePage.clickCompanyTab();
		companyPage.clickFBButton();
		Assert.assertTrue(musalaFaceBookPage.checkFBProfilePicture());
	}

	@BeforeMethod
	public void setup() 
	{
		if (PropertyManager.getInstance().getbrowser().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}

		else if (PropertyManager.getInstance().getbrowser().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.navigate().to(BaseTest.baseURL);
		driver.manage().window().maximize();
		companyPage = new CompanyPage(driver);
		homePage = new HomePage(driver);
		musalaFaceBookPage = new MusalaFaceBookPage(driver);
	}

	@AfterMethod
	public void teardown () 
	{
		driver.quit();
	}





}

