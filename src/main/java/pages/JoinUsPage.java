package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class JoinUsPage extends BasePage {

	//constructor
	public JoinUsPage(WebDriver driver) {
		super(driver);
	}

	//ElementLocators
	
	private By ExperiencedAutomationQAEngineerLink =
			By.xpath("//a[contains(.,'Experienced Automation QA Engineer')]");

	int i=1 ; 

	//Methods 
	@Step("Get the current URL")
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	@Step("Choose Anywhere from the dropdown list of the Location filter")
	public void chooseFromDropDownList() {
		By LocationDopDownList = By.xpath("//select[@id=\"get_location\"]");
		WebElement LocationDopDownListWebelemnt = driver.findElement(LocationDopDownList);
		Select Locations = new Select(LocationDopDownListWebelemnt);
		Locations.selectByValue("Anywhere");
	}
	@Step("Click on an open position-Experienced Automation QA Engineer")
	public void clickExperiencedAutomationQAEngineer() {
		driver.findElement(ExperiencedAutomationQAEngineerLink).click();
	}
	@Step("Print in the console the results of available positions by city")
	public void printIntoConsole() {
		
		
	
		String Location;
		for(int j = 0 ;j<1;j++) {
			Location = "Sofia";
			{
				By JobsListLocator = By.xpath("//p[contains(.,'"+Location+"')]");
				List<WebElement> JobList =driver.findElements(JobsListLocator);
				int JobListSize = JobList.size();
				System.out.println(Location);
				for(i=1;i<=JobListSize;i++) {
					By JobsTitelocator = By.xpath("//*[@id='content']/section/div[2]/article["+i+"]/div/a/div/div[1]/h2");
					String JobTitle = driver.findElement(JobsTitelocator).getText();
					By JobsLinkLocator = By.xpath("//*[@id='content']/section/div[2]/article["+i+"]/div/a");
					String JobLink = driver.findElement(JobsLinkLocator).getAttribute("href");
					System.out.println("Position: "+JobTitle);
					System.out.println("More informaton: "+JobLink);
				}
				System.out.println("--------------------------------------------------------------------------");
			}

			Location = "Skopje";
			{
				By JobsListLocator = By.xpath("//p[contains(.,'"+Location+"')]");
				List<WebElement> JobList =driver.findElements(JobsListLocator);
				int JobListSize = JobList.size();
				System.out.println(Location);
				for(i=1;i<=JobListSize;i++) {
					By JobsTitelocator = By.xpath("//*[@id='content']/section/div[2]/article["+i+"]/div/a/div/div[1]/h2");
					String JobTitle = driver.findElement(JobsTitelocator).getText();
					By JobsLinkLocator = By.xpath("//*[@id='content']/section/div[2]/article["+i+"]/div/a");
					String JobLink = driver.findElement(JobsLinkLocator).getAttribute("href");
					System.out.println("Position: "+JobTitle);
					System.out.println("More informaton: "+JobLink);
				}
			}
		}

	}

}





