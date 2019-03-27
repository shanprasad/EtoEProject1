package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email=By.cssSelector("[id='user_email']");
	By password=By.cssSelector("[type='password']");
	By login=By.cssSelector("[value='Log In']");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	driver = driver2;
	}
	

	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword() 
	{
		return driver.findElement(password);	
	}
	
	public WebElement getSubmit() 
	{
		return driver.findElement(login);	
	}

}
