package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.Cart;

public class RemoveMulItemfromCart extends AddMultiItemToCart {
	@Test(priority=2)
	
	public void removeMultiItemFromCart() throws InterruptedException {
		
		
		Cart cart=new Cart();
		if(cart.clickCart()==true) {
		
		while (true) {
            try {
                // Locate all remove buttons for the items in the cart
                List<WebElement> removeButtons = driver.findElements((By.xpath(loc.getProperty("removecart"))));

                // Break the loop if no items are left in the cart
                if (removeButtons.isEmpty()) {
                    break;
                }

                // Click the first remove button
                removeButtons.get(0).click();

                // Wait until the item is removed and the DOM is updated
                wait.until(ExpectedConditions.stalenessOf(removeButtons.get(0)));

            } catch (Exception e) {
                // Handle any exception (like stale element reference) gracefully
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
		Thread.sleep(2000);
		WebElement confbox=driver.findElement(By.xpath(loc.getProperty("confbox")));
		String actConfMsg=confbox.getText();
		wait.until(ExpectedConditions.visibilityOf(confbox));
		String expConfMsg="You don't have any items in your cart.";
		Assert.assertEquals(actConfMsg, expConfMsg);
		
		
			System.out.println("All items are removed successfully");
			Reporter.log("All items are removed successfully");
			
			
				}
		else {System.out.println("cart not clicked");
		Reporter.log("Cart not clicked");}
}
}


