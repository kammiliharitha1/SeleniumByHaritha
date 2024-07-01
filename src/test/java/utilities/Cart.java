package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseTest;

public class Cart extends BaseTest{
	public boolean clickCart() {
		
		WebElement cart=driver.findElement(By.xpath(loc.getProperty("CartIcon")));
		action.moveToElement(cart).perform(); 
		 cart.click();
		 System.out.println("cart Clicked");
		 String expectedCartTitle=loc.getProperty("ExpectedCartTitle");
		String actualCartTitle=driver.getTitle();
		Assert.assertEquals(actualCartTitle,expectedCartTitle);
		return true;
	}

}
