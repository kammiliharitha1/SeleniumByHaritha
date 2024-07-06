package tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.AddtoCartButton;

public class SearchProduct extends BaseTest {
	@Test
	public void search() {
		AddtoCartButton addcart = new AddtoCartButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//search laptop in the searchbox
		WebElement searchbox = driver.findElement(By.id(loc.getProperty("SearchBox")));
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys("laptop");
		searchbox.submit();
		//Filter brand as DELL
		WebElement brandFilter = driver.findElement(By.xpath(loc.getProperty("BrandFilter")));
		brandFilter.click();
		WebElement dell = driver.findElement(By.xpath(loc.getProperty("Dellbutton")));
		action.moveToElement(dell).perform();
		dell.click();
		//Filter with price
		WebElement priceFilter = driver.findElement(By.xpath(loc.getProperty("PriceFilter")));

		WebElement pricerange = driver.findElement(By.xpath(loc.getProperty("pricerangeunder80d")));
		WebElement scrolldown = driver.findElement(By.xpath(loc.getProperty("scrolldownto")));
		action.moveToElement(scrolldown).perform();
		wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
		if (priceFilter.getAttribute("aria-expanded").equalsIgnoreCase("true")) {
			wait.until(ExpectedConditions.elementToBeClickable(pricerange));
			pricerange.click();
			System.out.println("already expanded");
			
		} else {
			priceFilter.click();
			wait.until(ExpectedConditions.elementToBeClickable(pricerange));
			pricerange.click();
			System.out.println("expanded now");
			
		}
		//Click on the first item in the filtered list
		WebElement item1 = driver.findElement(By.cssSelector(loc.getProperty("item1")));
		String actitem=item1.getAttribute("alt");
		item1.click();
		//Go to the new window and add the item to cart
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		String parentwindow = itr.next();
		
		String childwindow = itr.next();
		
		driver.switchTo().window(childwindow);
		WebElement addToCart = driver.findElement(By.id(loc.getProperty("AddToCart")));
		WebElement itemPrice=driver.findElement(By.cssSelector(loc.getProperty("item1Price")));
		String actItemPrice=itemPrice.getText();
		

		wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		action.moveToElement(addToCart).perform();
		addToCart.click();

		//Verify the product and price of the item in the cart
		
		
		WebElement itemInCart=driver.findElement(By.cssSelector(loc.getProperty("IteminCart")));
		String expitem=itemInCart.getAttribute("alt");
		String expitemPrice=driver.findElement(By.xpath(loc.getProperty("IteminCartPrice"))).getText();
		
		Assert.assertEquals(actitem, expitem);
		Assert.assertEquals(actItemPrice, expitemPrice);
		System.out.println("Item selected= "+expitem +".It's Price is "+expitemPrice);
		
		

	}
	
	
		
	

}
