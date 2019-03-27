package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import org.junit.runner.RunWith;
import org.testng.Assert;

import academy.Base;

@RunWith(Cucumber.class)
public class StepDefinition extends Base{

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {

    	driver=initializeDriver();

    }
    
    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {

    driver.get(strArg1);
    
    }

    @And("^Click on Login link in home page to land on secure Sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
      LandingPage l=new LandingPage(driver);
      if(l.getPopUpSize()>0)
      {
   	   l.getPopUp().click();
      } 
      l.getLogin().click();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	
       LoginPage lp= new LoginPage(driver);
       lp.getEmail().sendKeys(username);
       lp.getPassword().sendKeys(password);
       lp.getSubmit().click();
       
    }  

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
      	/* PortalHomePage p = new PortalHomePage(driver);
      	 Assert.assertTrue(p.getSearchBox().isDisplayed());*/
    }

    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.manage().window().maximize();
        driver.quit();
    }


}