package tests;

import org.openqa.selenium.WebDriver;

import utilities.PropertyManager;


public class BaseTest {
	static final String baseURL = PropertyManager.getInstance().getURL();
	protected WebDriver driver;

	
}


