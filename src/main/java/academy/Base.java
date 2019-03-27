package academy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.internal.Utils;

public class Base {
	
	public static WebDriver driver;
    public Properties prop;
   
 
	public   WebDriver initializeDriver() throws IOException
	
	{
		prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\shank\\EtoEProject\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
	

	if (browserName.equals("chrome")) 
	{	
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	if (browserName.equals("firefox")) 
	{	
		System.setProperty("Webdriver.firefox.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	if (browserName.equals("IE"))
	{	
		System.setProperty("webdriver.edge.driver", ".\\Drivers\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	//return driver;

	}

	public void getScreenshot(String result) throws IOException 
	
	{	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		/*String des = System.getProperty("./screenshots/Screenshotname.png");
		File Dest = new File(des);
		FileUtils.copyFile(src, Dest);*/
		FileUtils.copyFile(src, new File(".//screenshots//"+result+"-"+"screenshot.png"));
	    
	}



}
