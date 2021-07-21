package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import pages.HomePage;
import utilities.AllureListener;
import utilities.PropertyManager;
import utilities.ReadExcel;


@Listeners({AllureListener.class})
public class TestCase1 extends BaseTest {

	private HomePage homePage;
	
	@Test(dataProvider ="ExcelData",description="Verify invalid email address on Contact us form" )
	@Description("Verify that invalid email address returns the expected error msg")
	@Epic ("MusalaSoft TestCase1")
	public void checkInvalidEmailMessage(String InvalidEmails) {
		homePage.clickContactUS();
		homePage.enterName("sayed");
		homePage.enterEmail(InvalidEmails);
		homePage.enterSubject("mySubject");
		homePage.enterMessageText("This is My message");
		homePage.clickSubmitButton();
		
		Assert.assertEquals(homePage.getErrorMessage(),
				"The e-mail address entered is invalid."); 
	}

	@DataProvider(name="ExcelData")
	public String[][] ExcelData() throws InvalidFormatException, IOException {
		ReadExcel reader = new ReadExcel();
		return reader.ReadSheet();
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
		homePage = new HomePage(driver);

	}


	@AfterMethod
	public void teardown () {
		driver.quit();
	}
	
}











