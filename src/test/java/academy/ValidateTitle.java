package academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateTitle extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	

	@Test
		public void validateAppTitle() throws IOException

		{ 
			LandingPage l= new LandingPage(driver);
			Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
			log.info("Successfully validated Text message");	
		}   

	   @AfterTest
	   public void teardown()
	   {
		   driver.close();
		   driver=null;
	   }

}
