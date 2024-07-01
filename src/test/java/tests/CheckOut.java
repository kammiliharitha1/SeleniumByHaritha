package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Cart;

public class CheckOut extends  AddItemToCart{
	@Test(priority=2)
	public void checkOut() throws InterruptedException {
		Cart cart=new Cart();
		if(cart.clickCart()==true) {
		
	WebElement checkOut=driver.findElement(By.xpath(loc.getProperty("CheckOut")));		
	wait.until(ExpectedConditions.elementToBeClickable(checkOut));
	checkOut.click();
	wait.until(ExpectedConditions.titleContains("Sign in or Register | eBay"));
	WebElement email=driver.findElement(By.id(loc.getProperty("SignInEmailbtn")));
	wait.until(ExpectedConditions.visibilityOf(email));
	email.sendKeys(loc.getProperty("SignInemail"));
	WebElement contBtn=driver.findElement(By.id(loc.getProperty("Continuebtn")));
	wait.until(ExpectedConditions.elementToBeClickable(contBtn));
	contBtn.click();
	WebElement pwd=driver.findElement(By.xpath(loc.getProperty("SignInPwdbtn")));
	wait.until(ExpectedConditions.visibilityOf(pwd));
	pwd.sendKeys(loc.getProperty("SignInPwd"));
	driver.findElement(By.xpath(loc.getProperty("SignInbtn"))).click();
	String ExpCheckOutTitle=loc.getProperty("CheckOutPageTitle");
	String ActCheckOutTitle=driver.getTitle();
	wait.until(ExpectedConditions.titleContains(ExpCheckOutTitle));
	Assert.assertEquals(ActCheckOutTitle,ExpCheckOutTitle);
		}
		
		else {
			System.out.println("Cart not clicked");
		}
	
	
	 
	}

}
