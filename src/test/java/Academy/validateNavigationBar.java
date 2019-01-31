package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base{
	
	//for log purposes
	private static Logger log = LogManager.getLogger(validateNavigationBar.class.getName());
		
	@BeforeTest
	public void initialize() throws IOException {
		
		//since driver is defined as public in base class, it is accessible by inheriting the class
		driver = initializeDriver();
		
		log.info("Driver is initialized");
				
		/*
		* removing the hard coded values
		*/
		//driver.get("http://www.qaclickacademy.com/");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateContact() throws IOException {
		
		
		LandingPage pag1 = new LandingPage(driver);
		
				
		//
		Boolean a1 = pag1.getContactTab().isDisplayed();
		Assert.assertTrue(a1);
		
		log.info("validateContact is pass");
		
	
	}
	
	@AfterTest
	public void teadown() {
		
		driver.close();
		
		//clean the driver object from memory
				driver = null;
	}
	
	
}
