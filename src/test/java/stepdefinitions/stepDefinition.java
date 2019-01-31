package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition extends base{

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    
	   
		driver = initializeDriver();
	}

	@Given("^navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_site(String arg1) throws Throwable {
	    
		driver.get(arg1);
	}

	@Given("^Click on the Login link in the hom epage to land on secure sign in page$")
	public void click_on_the_Login_link_in_the_hom_epage_to_land_on_secure_sign_in_page() throws Throwable {

		LandingPage pag1 = new LandingPage(driver);
		
		/*
		 * this check is to close the popup window
		 * if the popup window appears, it will first close it and the proceed
		 */
		if(pag1.getpopupSize()>0) {
			
			pag1.getPopUp().click();
		}
		
		pag1.getLogin().click();
	    
	}

	/*@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
		
		LoginPage pag2 = new LoginPage(driver);
		
		//this section will be looped 3 times because getData method has 3 value sets
		pag2.setEmail().sendKeys(arg1);
		pag2.setPassowrd().sendKeys(arg2);
		pag2.clickbtnLogin().click();
	    
	}*/

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
	    
		portalHomePage pag3 = new portalHomePage(driver);
		Assert.assertTrue(pag3.setsearchBox().isDisplayed());
		
	    
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
        
		LoginPage pag2 = new LoginPage(driver);
		
		//this section will be looped 3 times because getData method has 3 value sets
		pag2.setEmail().sendKeys(username);
		pag2.setPassowrd().sendKeys(password);
		pag2.clickbtnLogin().click();
    }
	
	  @And("^Close the browsers$")
	    public void close_the_browsers() throws Throwable {

		  driver.close();
	    }


}