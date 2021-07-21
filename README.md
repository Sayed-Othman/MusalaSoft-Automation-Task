# MusalaSoft-Test Automation-Task
 
The Framework is designed using Selenium WebDriver in Java Language. It supports cross browsing testing, parallel execution, data driven testing from an Excel file,	automated Screenshots for test results (Passes & Failures) and it is supported by a report manager for the test runs. 

Tools used: Selenium Webdriver, Maven, TestNG, Apache POI, Allure Report and Extent Reports

Below are more details and illustrations about the design of the framework and snippets of the generated reports for the test runs

# POM
 
I am using the Page Object Model design pattern. I have maintained a class for each web page which includes its element locators and methods and also a Base class to maintain the generic methods and to load the base URL from the Configuration File.
 
# Packages
 
Pages Package: includes all the web page related classes 
 
Tests Package: includes all the tests related classes.
 
Utility Package: maintains utility classes such as Property Manager, ReadExcel, Listener and Extent Report.  

![Project Explorer](https://user-images.githubusercontent.com/72825028/126540911-b875cfc3-98bf-4a91-becd-863b5e4058ea.JPG)
 
# Properties file
 
This file (config.properties) stores the information that remains static throughout the framework such as browser-specific information to support two browsers -chrome&firefox-, ScreenShots Folder Path, Base URL http://www.musala.com, and Test data path. 

# Parallel Execution
 
is possible using TestNG XML file and it is also possible to set the number of threads.
 
![Parallel Execution](https://user-images.githubusercontent.com/72825028/126481930-bcb6a039-7230-40c0-90b3-097b2f22e221.JPG)

# Screenshots 

screenshots of tests results (passed and failed tests) are captured and stored after test runs in a separate folder

![Screenshot testcase1](https://user-images.githubusercontent.com/72825028/126541081-929281a8-275e-4adb-b793-9c559cee0069.JPG)
 
# Reporting
 
I use the Allure Reporting framework and I use Allure Annotations to add description  for each test method/class used and for the test execution steps in the reports.

Below are some screenshots from the Allure report showcasing the  test classes and cases, description and execution steps. Test cases execution is prioritized as described in the task.
 
![Overview report](https://user-images.githubusercontent.com/72825028/126482003-2ba840c2-d0d9-41aa-a175-78515e8d6d5f.JPG)
 
![FB URL and Profile image report](https://user-images.githubusercontent.com/72825028/126482060-4a911fb4-41f9-425c-91fd-ea10c91bbf86.JPG)
 
![Error msgs application form report](https://user-images.githubusercontent.com/72825028/126482074-3e58742e-8ec4-4589-b72b-cb1918160d61.JPG)
 
# Test Case 4 results
 
![Print in the console](https://user-images.githubusercontent.com/72825028/126482149-53e3b5e2-fd0c-4bb5-99f8-c6d77d111b7b.JPG)
 

 
 

