package testClasses;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObject.Login;

public class TestLoginPage extends BaseSetup {

	public Login login;
	
	public TestLoginPage()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		login = new Login();
	}
	
	@Test
	public void testUserNameField()
	{
		login.login_UserNamefield("standard_user");
	}
	
	@Test
	public void testPasswordField()
	{
		login.login_Passwordfield("secret_sauce");
	}
	
	@Test
	public void testLoginButton()
	{
		login.login_loginButton();
	}
	
	
}
