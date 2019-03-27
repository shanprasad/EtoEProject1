package academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
	
  @Test(dataProvider="getData")
	public void basePageNavigation (String  email, String password, String text) throws IOException 

	{
		driver.get(prop.getProperty("url"));
	    LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.getEmail().sendKeys(email);
	    lp.getPassword().sendKeys(password);
	    lp.getSubmit().click();
	    System.out.println(text);
	    log.info("Home page displayed");
	}   


@AfterTest
public void teardown()
{
	   driver.close();
	   driver=null;
}


   @DataProvider
   public Object[][] getData()
   {
	Object[][] data=new Object[2][3];
	
	data[0][0]="Resuser@gmail.com";
	data[0][1]="12345678";
	data[0][2]="Restricted User";
	
	data[1][0]="nonResuser@gmail.com";
	data[1][1]="1234";
	data[1][2]="Non-Restricted User";
	
	return data;
   }
 
}
