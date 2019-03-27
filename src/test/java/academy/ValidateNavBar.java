package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateNavBar extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
		
		@Test
			public void validateNavBar() throws IOException
		   { 
			
				
				LandingPage l= new LandingPage(driver);
				Assert.assertTrue(l.getNavBar().isDisplayed());
				log.info("Navigation bar is displayed");
			}   

   @AfterTest
   public void teardown()
   {
	   driver.close();
	   driver=null;
   }
	

}
