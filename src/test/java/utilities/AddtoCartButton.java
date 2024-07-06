package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AddtoCartButton extends BaseTest{
	
	public boolean addtoCartButton() {
		WebElement addToCart = driver.findElement(By.id(loc.getProperty("AddToCart")));
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		action.moveToElement(addToCart).perform();
		addToCart.click();
		Boolean status=wait.until(ExpectedConditions.textToBePresentInElement(addToCart, "View in cart"));
		System.out.println("Item added to Cart successfully");
		if(status==true) {
			return true;
		}
		else {
			return false;
		}
	}

}
