package testClasses;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObject.LoginTest;
import pageObject.ProductsTest;

public class LoginPageTest extends BaseSetup {

	public LoginTest login;
	public ProductsTest prod;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		login = new LoginTest();
	}
	
	@Test(priority = 1)
	public void testUserNameField()
	{
		login.login_UserNamefield("standard_user");
	}
	
	@Test(priority = 2)
	public void testPasswordField()
	{
		login.login_Passwordfield("secret_sauce");
	}
	
	@Test(priority = 3)
	public void testLoginButton()
	{
		prod = login.login_loginButton();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
}
