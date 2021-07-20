package tests;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import pages.CareerPage;
import pages.HomePage;
import pages.JoinUsPage;
import utilities.AllureListener;
import utilities.PropertyManager;

@Listeners({AllureListener.class})
public class TestCase4  extends BaseTest{
	private HomePage homePage;
	private CareerPage careerPage;
	private JoinUsPage joinUsPage;

	@Test(priority=0,description="Print available positions in selected cities" )
	@Description("Print in the console with a specific format all available positions for Sofia and Skopje")
	@Epic("Musalasoft TestCase4")
	public void printAvailablePositionsInCity() {

		homePage.clickCareerTab();
		careerPage.clickOpenPositions();
		joinUsPage.printIntoConsole();	  
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

		driver.navigate().to(BaseTest.baseURL);
		driver.manage().window().maximize();
		joinUsPage = new  JoinUsPage(driver);
		careerPage = new CareerPage(driver);
		homePage = new HomePage(driver);
	}	

	@AfterMethod
	public void teardown () {
		driver.quit();
	}

}
