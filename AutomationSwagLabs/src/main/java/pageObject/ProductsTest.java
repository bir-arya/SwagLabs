package pageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSetup;

public class ProductsTest extends BaseSetup {

	@FindBy (css = "div.inventory_item_name") WebElement productsName;
	public	List<WebElement> addToCartButton = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
	@FindBy (css = "a.shopping_cart_link") WebElement cartButton;

	public ProductsTest()
	{
		PageFactory.initElements(driver, this);
	}

	public void product_selectProduct()
	{	
		int i=0, j=0;
		String[] name = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie"};
		List<WebElement> list =  driver.findElements(By.cssSelector("div.inventory_item_name"));
		
		for(i=0; i<list.size(); i++)
		{
			String products = list.get(i).getText();
			List<String> itemNeededList = Arrays.asList(name);
	
			if(itemNeededList.contains(products))
			{
				j++;
				addToCartButton.get(i).click();
	
				if(j==name.length)
				{
					break;
				}
			}
		}
				
	}
	
	
	public CartTest product_NavigateToCart() {
		
		cartButton.click();
		return new CartTest();
	}
}
