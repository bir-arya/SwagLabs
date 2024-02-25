package pageObject;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;

public class LoginTest extends BaseSetup {

	Logger log = LogManager.getLogger(LoginTest.class.getClass());
	
	@FindBy (xpath = "//input[@id='user-name']") WebElement userNameField;
	@FindBy (css = "input[id='password']") WebElement passwordField;
	@FindBy (css = "input[id='login-button']") WebElement loginButton;
	@FindBy (className = "footer") WebElement footer;
	@FindBy (tagName = "LinkedIn") WebElement linkedInIcon;
	@FindBy (css = "div.error-message-container.error") WebElement errorText;
	@FindBy (css ="button.error-button") WebElement errorCloseButton;
	
	
	public LoginTest()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login_UserNamefield(String username)
	{
		log.info("Entering User Name");
		userNameField.sendKeys(username);
		log.info("User Name entered");
	}
	
	public void login_Passwordfield(String password)
	{
		log.info("Entering password");
		passwordField.sendKeys(password);
		log.info("Password entered");
	}
	
	public void links() throws InterruptedException
	{
		//linkedInIcon.click();
		
		//footer.findElements(By.tagName("a")).size();
		//String currentWindowTitle = null;
		
		
		for(int i=0; i<footer.findElements(By.tagName("a")).size(); i++)
		{
			
			String keyControl = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footer.findElements(By.tagName("a")).get(i).sendKeys(keyControl);
			Thread.sleep(5000);
		}
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
			
		while(it.hasNext())
		{
				
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		//driver.switchTo().window();
	}
		
	
	public ProductsTest zlogin_loginButton()
	{
		loginButton.click();
		return new ProductsTest();
	}
	
	
	public void test(String username, String password) throws InterruptedException
	{
		
		
		
		userNameField.sendKeys(username);
		System.out.println(username +" " + password);
		passwordField.sendKeys(password);
		Thread.sleep(2000);
		loginButton.click();
		
		Thread.sleep(2000);
		//int j=0;
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html"))
		{
			//Thread.sleep(1000);
			passwordField.click();
			passwordField.clear();
			//Thread.sleep(1000);
			userNameField.click();
			userNameField.clear();	
			Thread.sleep(1000);
			errorCloseButton.click();
			//j++;
		}
		
	}
	
}
