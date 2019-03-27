package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//*[@id='content']/div/div/h2");
	By NavBar=By.cssSelector("body > header > div.navbar.navbar-default.navbar-static-top > div > nav");
	By popup = By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}
	

	public WebElement getLogin() 
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() 
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() 
	{
		return driver.findElement(NavBar);
	}
	public WebElement getPopUp() 
	{
		return driver.findElement(popup);
	}
	
	public int getPopUpSize() 
	{
		return driver.findElements(popup).size();
	}
}
