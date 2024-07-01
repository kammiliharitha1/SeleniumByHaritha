package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Cart;

public class RemoveItemfromCart extends AddItemToCart {
	@Test(priority=2)
	
	public void removeItemFromCart() throws InterruptedException {
		
		
		Cart cart=new Cart();
		if(cart.clickCart()==true) {
		WebElement removecart=driver.findElement(By.xpath(loc.getProperty("removecart")));
		removecart.click();
		Thread.sleep(2000);
		WebElement confbox=driver.findElement(By.xpath(loc.getProperty("confbox")));
		String actConfMsg=confbox.getText();
		wait.until(ExpectedConditions.visibilityOf(confbox));
		String expConfMsg="You don't have any items in your cart.";
		Assert.assertEquals(actConfMsg, expConfMsg);
		System.out.println("Item is removed from cart successfully");}
		else {
			System.out.println("cart not clicked");
		}
		
		
		

}
}
