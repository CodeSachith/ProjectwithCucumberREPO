package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	
	//define webdriver
	public WebDriver driver;
	
	// define objects
	By searchBox = By.name("query"); 
	
	
	
	
	//constructor to set driver
	public portalHomePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver2;
	}

	//define methods to access objects

	public WebElement setsearchBox() {
		
		return driver.findElement(searchBox);
	}

	

}
