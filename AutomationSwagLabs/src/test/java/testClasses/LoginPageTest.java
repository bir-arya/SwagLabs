package testClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObject.LoginTest;
import pageObject.ProductsTest;
import util.DataProviderClass;

public class LoginPageTest extends BaseSetup {

	public LoginTest login;
	public ProductsTest prod;
	
	DataProviderClass dataProvider = new DataProviderClass();
	
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
	public void testUserNameField() throws IOException
	{
		ArrayList<String> test = dataProvider.main("UserName");
		for(String s : test)
		{
		login.login_UserNamefield(s);
		}
	}
	
	@Test()
	public void testLogin() throws IOException, InterruptedException
	{
		
		DataProviderClass data = new DataProviderClass();
		ArrayList<String> test = data.main("UserName");
		ArrayList<String> test1 = data.main("Password");
	//	ArrayList<String> test = dataProvider.main("UserName");
	//	ArrayList<String> test1 = dataProvider.main("Password");
		
		//System.out.println(test);
		//System.out.println(test1);
		
		for(int i=0; i<test.size(); i++)
		{
		login.test(test.get(i), test1.get(i));
		}
	}
	
	@Test(dependsOnMethods = "testUserNameField")
	public void testPasswordField()
	{
		login.login_Passwordfield("secret_sauce");
	}
		
	@Test(dependsOnMethods = "testPasswordField")
	public void testLoginButton()
	{
		prod = login.zlogin_loginButton();
	}
	
	@Test(dependsOnMethods = "testLoginButton")
	public void testLinkedInLink() throws InterruptedException
	{
//		String windowTitle = login.linkedInLink();
//		System.out.println(windowTitle);
		
		//String windowTitle = login.links();
		login.links();
		//System.out.println(windowTitle);
		
	}
	
	//@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
}
