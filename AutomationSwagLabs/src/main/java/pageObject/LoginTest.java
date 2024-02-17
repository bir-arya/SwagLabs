package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSetup;

public class LoginTest extends BaseSetup {

	@FindBy (xpath = "//input[@id='user-name']") WebElement userNameField;
	@FindBy (css = "input[id='password']") WebElement passwordField;
	@FindBy (css = "input[id='login-button']") WebElement loginButton;
	
	public LoginTest()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login_UserNamefield(String uername)
	{
		userNameField.sendKeys(uername);
	}
	
	public void login_Passwordfield(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public ProductsTest login_loginButton()
	{
		loginButton.click();
		return new ProductsTest();
	}
	
}
