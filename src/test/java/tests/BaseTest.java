package tests;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.google.common.io.Files;
import utilities.PropertyManager;
public class BaseTest {
	static final String baseURL = PropertyManager.getInstance().getURL();
	protected WebDriver driver;

	@AfterMethod
	public void Teardown(ITestResult result){
		if(ITestResult.SUCCESS == result.getStatus())
		{
			TakesScreenshot   camera = (TakesScreenshot)driver;
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			try{
				Files.move(screenshot, new File
						( System.getProperty("user.dir")
								+PropertyManager.getInstance().getScreenShotsFolderPath() +
								result.getName() + 
								".png"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else if(ITestResult.FAILURE == result.getStatus())
		{
			TakesScreenshot   camera = (TakesScreenshot)driver;
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			try{
				Files.move(screenshot, new File
						( System.getProperty("user.dir")
								+PropertyManager.getInstance().getScreenShotsFolderPath() +
								result.getName() + 
								".png"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}


