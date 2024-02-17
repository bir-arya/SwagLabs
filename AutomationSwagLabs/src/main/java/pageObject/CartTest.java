package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSetup;

public class CartTest extends BaseSetup {

	@FindBy (css = "div.inventory_item_name") WebElement productName;
	@FindBy (css = "button[id='checkout']") WebElement checkOutButton;
	@FindBy (css = "input[id='first-name']") WebElement firstNameField;
	@FindBy (css = "input[id='last-name']") WebElement lastNameField;
	@FindBy (css = "input[id='postal-code']") WebElement postalCodeField;
	@FindBy (css = "input[id='continue']") WebElement continueButton;
	
	
	public CartTest()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean cart_CheckItems()
	{
		return productName.isDisplayed();
	}
	
	public void cart_ClickCheckOutButton()
	{
		checkOutButton.click();
	}
	
	public void cart_FirstNameField(String fName)
	{
		firstNameField.sendKeys(fName);;
	}
	
	public void cart_lastNameField(String lName)
	{
		firstNameField.sendKeys(lName);;
	}
	
	public void cart_PostalCodeField(String postalCode)
	{
		firstNameField.sendKeys(postalCode);;
	}
	
	public void cart_ContinueButton()
	{
		continueButton.click();
	}
}
