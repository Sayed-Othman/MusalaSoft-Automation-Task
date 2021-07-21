package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

public class MusalaFaceBookPage extends BasePage {

	//Constructor
	public MusalaFaceBookPage(WebDriver driver) {
		super(driver);
	}

	//Elements
	private By ProfilePic = By.xpath("//img[@class='_6tb5 img']");

	//Methods 
	@Step("Get the current URL for the Facebook page")
	public String getURL() {
		return driver.getCurrentUrl();
	}
	@Step("Check that the profile picture on Facebook page is visible")
	public boolean checkFBProfilePicture() {
		WebElement MusalaProfileImg =	driver.findElement(ProfilePic);
		BasePage.hoverOnTheElement(MusalaProfileImg);
		return MusalaProfileImg.isDisplayed();
	}
}
