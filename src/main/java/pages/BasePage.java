package pages;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver=driver;
	}

	public  static void waitForVisibility(WebDriver driver , int time , By elementName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementName));
	}

	public  static void presenceOfElement(WebDriver driver , int time , By elementName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementName));
	}

	public  static void waitForClickability(WebDriver driver , int time , By elementName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	}

	public  static void waitForClickability(WebDriver driver , int time , WebElement elementName) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	}

	public static void hoverOnTheElement(WebElement WebelementName) {
		Actions action = new Actions(driver);
		action.moveToElement(WebelementName).build().perform();
	}

	public static void  scrollIntoView(WebElement elementName) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView()",elementName);

	}

	//This method for switching the window Using window handles.
	public static void switchWindow(){
		String currentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		java.util.Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext()){
			String childwindow = itr.next();
			if(!childwindow.equalsIgnoreCase(currentwindow)){
				driver.switchTo().window(childwindow);
			}
		}
	}

	//This method is for finding and clicking footer elements .
	// int j represents the order of the footer element.
	//for FaceBook button j = 3. for ContactUs button j = 0. 
	public static void  footerElements(int j) {
		By FooterLinks = By.xpath("//div[@class='links-buttons']");
		WebElement footer = driver.findElement(FooterLinks);
		List<WebElement>footlinks=footer.findElements(By.tagName("a"));
		WebElement elementName = footlinks.get(j);

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elementName));

		Actions action = new Actions(driver);
		action.moveToElement(elementName).click(elementName).perform();	
	}


}
