package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseTest;

public class Cart extends BaseTest{
	public boolean clickCart()  {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		action=new Actions(driver);
		WebElement cart=driver.findElement(By.xpath(loc.getProperty("CartIcon")));
		System.out.println("Element found is "+cart.getAttribute("aria-label"));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		action.moveToElement(cart).perform(); 
		 cart.click();
		 System.out.println("cart Clicked");
		 String expectedCartTitle=loc.getProperty("ExpectedCartTitle");
		String actualCartTitle=driver.getTitle();
		Assert.assertEquals(actualCartTitle,expectedCartTitle);
		return true;
	}

}
