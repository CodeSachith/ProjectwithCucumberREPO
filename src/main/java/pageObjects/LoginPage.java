package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//define webdriver
	public WebDriver driver;
	
	// define objects
	By email = By.cssSelector("[id='user_email']"); 
	By passwrd = By.cssSelector("[type='password']");
	By btnLogin = By.cssSelector("[value = 'Log In']");
	
	
	
	//constructor to set driver
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver2;
	}

	//define methods to access objects

	public WebElement setEmail() {
		
		return driver.findElement(email);
	}

	public WebElement setPassowrd() {
		
		return driver.findElement(passwrd);
	}
	
	public WebElement clickbtnLogin() {
		
		return driver.findElement(btnLogin);
	}
	

}
