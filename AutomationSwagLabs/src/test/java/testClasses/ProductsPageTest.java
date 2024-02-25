package testClasses;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObject.CartTest;
import pageObject.LoginTest;
import pageObject.ProductsTest;

public class ProductsPageTest extends BaseSetup{

	LoginTest login;
	ProductsTest prod;
	CartTest cart;
	
	public ProductsPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		login= new LoginTest();
		login.login_UserNamefield("standard_user");
		login.login_Passwordfield("secret_sauce");
		prod = login.zlogin_loginButton();
		
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
