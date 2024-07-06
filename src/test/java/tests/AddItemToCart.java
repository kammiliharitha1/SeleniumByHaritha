package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddItemToCart extends BaseTest {
	
	@Test(priority = 1)
	public void addItemToCart() throws InterruptedException {
		driver.manage().window().maximize();
		// Hover on Fashion
		WebElement fashion = driver.findElement(By.xpath(loc.getProperty("FashionHover")));
		
		wait.until(ExpectedConditions.visibilityOf(fashion));

		action.moveToElement(fashion).perform();
		// Click on Accessories for Women
		WebElement accForWomen = driver.findElement(By.xpath(loc.getProperty("AccforWomen")));
		wait.until(ExpectedConditions.elementToBeClickable(accForWomen));
		accForWomen.click();
		// Click on Hats
		WebElement hats = driver.findElement(By.cssSelector(loc.getProperty("Hats")));
		wait.until(ExpectedConditions.elementToBeClickable(hats));
		hats.click();
		String actualItemTitle = driver.getTitle();
		String expectedItemTitle = loc.getProperty("ExpectedItemTitle");
		Assert.assertEquals(actualItemTitle, expectedItemTitle);
		// Click on shopByCategory-CowBoyHat
		WebElement cowBoyHat = driver.findElement(By.xpath(loc.getProperty("CowBoyHat")));
		action.moveToElement(cowBoyHat).perform();
		cowBoyHat.click();
		String actualCategoryTitle = driver.getTitle();
		String expectedCategoryTitle = loc.getProperty("ExpectedCategoryTitle");
		Assert.assertEquals(actualCategoryTitle, expectedCategoryTitle);
		// Click on one Item
		WebElement selectedItem = driver.findElement(By.xpath(loc.getProperty("SelectedItem")));
		String expectedSelItemURL = selectedItem.getAttribute("href");
		wait.until(ExpectedConditions.elementToBeClickable(selectedItem));
		selectedItem.click();
		System.out.println("Item clicked");
		

		String actualSelItemURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualSelItemURL, expectedSelItemURL);
		// Add to cart
		WebElement addToCart = driver.findElement(By.id(loc.getProperty("AddToCart")));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		action.moveToElement(addToCart).perform();
		addToCart.click();
		wait.until(ExpectedConditions.textToBePresentInElement(addToCart, "View in cart"));
		System.out.println("Item added to Cart successfully");
		Reporter.log("Item added to Cart successfully");

	}

	
}
