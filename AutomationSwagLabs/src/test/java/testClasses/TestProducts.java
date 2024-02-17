package testClasses;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObject.CartPage;
import pageObject.Login;
import pageObject.Products;

public class TestProducts extends BaseSetup{

	Login login;
	Products prod;
	CartPage cart;
	
	public TestProducts()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		login= new Login();
		login.login_UserNamefield("standard_user");
		login.login_Passwordfield("secret_sauce");
		prod = login.login_loginButton();
		
	}
	
	@Test
	public void test_products()
	{
		prod.product_selectProduct();
	}
	
	@Test(dependsOnMethods = "test_products")
	public void test_NavigateToCart()
	{
		cart = prod.product_NavigateToCart();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
