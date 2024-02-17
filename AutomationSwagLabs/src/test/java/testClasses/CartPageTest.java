package testClasses;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseSetup;
import pageObject.CartTest;
import pageObject.LoginTest;
import pageObject.ProductsTest;

public class CartPageTest extends BaseSetup{

	boolean checkItem;
	LoginTest login;
	ProductsTest prod;
	CartTest cart;
	
	SoftAssert soft = new SoftAssert();
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		login = new LoginTest();
		login.login_UserNamefield("standard_user");
		login.login_Passwordfield("secret_sauce");
		login.login_loginButton();
		
		prod = new ProductsTest();
		prod.product_selectProduct();
		cart = prod.product_NavigateToCart();
		
	}
	
	@Test(priority = 1)
	public void test_CheckCartItem()
	{
		checkItem = cart.cart_CheckItems();
		soft.assertTrue(checkItem,"Item not added" );
	}
	
	@Test(priority = 2)
	public void test_CartClickCheckOutButton()
	{
		cart.cart_ClickCheckOutButton();
	}
	
	@Test(priority = 3)
	public void test_CartFirstNameField()
	{
		cart.cart_FirstNameField("Birjoo");
	}
	
	@Test(priority = 4)
	public void test_CartlastNameField()
	{
		cart.cart_lastNameField("Arya");
	}
	
	@Test(priority = 5)
	public void test_CartPostalCodeField()
	{
		cart.cart_PostalCodeField("23923");
	}
	
	//test
	@Test(priority = 6)	
	public void test_CartContinueButton()
	{
		cart.cart_ContinueButton();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
