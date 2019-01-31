package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	//define web driver
	public WebDriver driver;
	
	// define objects
	By signin = By.cssSelector("a[href*='sign_in']");
	
	By Title = By.cssSelector(".text-center>h2");
	
	By ContactTab = By.cssSelector("a[href*='contact']");
	
	By popup = By.xpath("//button[text()='NO THANKS']");
	
	
	
	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver2;
	}

	//define methods to access objects

	public WebElement getLogin() {
		
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		  
		
		return driver.findElement(Title);
				
	}
	
	public WebElement getContactTab() {
		
		return driver.findElement(ContactTab);
		
	}
	
	public int getpopupSize() {
		
		return driver.findElements(popup).size();
		
	}
	
	public WebElement getPopUp() {
		
		return driver.findElement(popup);
	}

}
