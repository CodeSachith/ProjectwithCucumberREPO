package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.apache.commons.io.FileUtils;


//import org.apache.commons.io.FileUtils;

public class base {
	
	/*
	 * the scope of the driver, when defined in the loop, is limited to that loop only
	 * therefore, driver is defined at the class level so that 
	 * 
	 * make the driver static so that where ever the driver is used, it is always referenced to the same location where it was initialized
	 */
	public static WebDriver driver;
	
	//prop object is defined outside the method(class level) so that child classes have access to it
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	
	/*
	 * when prop object is defined inside the method, its scope is only the method. Then the classes inheriting the base class can not refer prop object
	 * so  prop object is defined outside the method(class level) and initialize inside the method (where required)
	 */
	//Properties prop = new Properties();
	prop = new Properties();	
	FileInputStream fis = new FileInputStream("C:\\Users\\Sachith\\Project\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome") ) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sachith\\Downloads\\jars for selenium\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		 driver = new ChromeDriver();
	}
	
	else if(browserName.equals("firefox")) {
		
		//WebDriver driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		
	}
	
	else if(browserName.equals("IE")) {
		
		//WebDriver driver = new  InternetExplorerDriver();
		driver =  new  InternetExplorerDriver();
	}
	
	
	//time out
	/*
	 * this will be the standard time out for driver to load the web page. after this time out, if the page didn't load, test case will fail
	 * 
	 * by defining it at the base class, you don't need to define it at each test case.
	 * and of the standard time out need to be modified, you only have to change in a single location
	 */
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	return driver;
	
	}
	
	//method to take screenshots
	/*public void getScreenshot(String result) throws IOException {
		
		//web driver takes the screen shot and save in the virtual location called "src"
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//copy the file to local machine from the virtual location
		FileUtils.copyFile(src,new File("C://Users//Sachith//Pictures/"+result+"screenshot.png"));
		
		
	}*/

}
