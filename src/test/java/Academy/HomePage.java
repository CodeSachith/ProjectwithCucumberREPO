package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	//for log purposes
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
		
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
		
		
		//creating an object from LandingPage class because we need to use the getLogin method in the LandingPage class to access login web element
				LandingPage pag1 = new LandingPage(driver);
				
				pag1.getLogin().click();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException {
		
		
		
		
		LoginPage pag2 = new LoginPage(driver);
		
		//this section will be looped 3 times because getData method has 3 value sets
		pag2.setEmail().sendKeys(Username);
		pag2.setPassowrd().sendKeys(Password);
		pag2.clickbtnLogin().click();
		
		log.info("Login test pass");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "validuser@lseg.com";
		data[0][1] = "validuserpassowrd";
		
		data[1][0] = "invaliduser@lseg.com";
		data[1][1] = "invaliduserpassowrd";
		
		data[2][0] = "validuser1@lseg.com";
		data[2][1] = "validuser1passowrd";
		
		return data;
		
	}
	
	@AfterTest
	public void teadown() {
		
		driver.close();
		
		//clean the driver object from memory
		driver = null;
	}

}
