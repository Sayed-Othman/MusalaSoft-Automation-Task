package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class CareerPage extends BasePage {

	//Constructor
	public CareerPage(WebDriver driver) {
		super(driver);
	}

	//ElementLocators
	private By OpenPositionButton = By.xpath("//span[contains(.,'Check our open positions')]");

	//Methods
	@Step("Click on Check our open positions button")
	public void clickOpenPositions(){
		driver.findElement(OpenPositionButton).click();		
	}

}
