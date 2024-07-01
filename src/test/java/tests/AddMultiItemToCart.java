package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddMultiItemToCart extends BaseTest {
	// public static WebDriverWait wait1 = new WebDriverWait(driver,
	// Duration.ofSeconds(10));
	// public static Actions action = new Actions(driver);

	@Test(priority = 1)
	public void addMultiItemToCart() {
		driver.manage().window().maximize();
		// Hover on Fashion
		WebElement fashion = driver.findElement(By.xpath(loc.getProperty("FashionHover")));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
		Actions action = new Actions(driver);
		wait1.until(ExpectedConditions.visibilityOf(fashion));

		action.moveToElement(fashion).perform();
		// Click on Accessories for Women
		WebElement accForWomen = driver.findElement(By.xpath(loc.getProperty("AccforWomen")));
		wait1.until(ExpectedConditions.elementToBeClickable(accForWomen));
		accForWomen.click();
		// Click on Hats
		WebElement hats = driver.findElement(By.cssSelector(loc.getProperty("Hats")));
		wait1.until(ExpectedConditions.elementToBeClickable(hats));
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
		// Select Multiple Items
		List<WebElement> selecteditems = driver.findElements(By.xpath(loc.getProperty("Items")));
		for (int i = 0; i <= 2; i++) {
			boolean isStale = true;
            int attempts = 0;
            while (isStale && attempts < 3) {
                try {
			selecteditems = driver.findElements(By.xpath(loc.getProperty("Items")));
			
			WebElement item=selecteditems.get(i);
			System.out.println("Clicking on Item "+i+selecteditems.get(i).getText());
			wait1.until(ExpectedConditions.elementToBeClickable(item));
			item.click();
			
			WebElement addToCart = driver.findElement(By.id(loc.getProperty("AddToCart")));
			
			wait1.until(ExpectedConditions.visibilityOf(addToCart));
			
			action.moveToElement(addToCart).perform();
			addToCart.click();
			wait1.until(ExpectedConditions.textToBePresentInElement(addToCart, "View in cart"));
			System.out.println("Item" + i + " added to Cart successfully");
			
			driver.navigate().back();
			wait1.until((ExpectedConditions.visibilityOf(item)));
			 isStale = false; // If no exception, exit the loop
                } catch (StaleElementReferenceException e) {
                    // Increment the attempts counter
                    attempts++;
                    System.out.println("StaleElementReferenceException caught. Attempt: " + attempts);
                }
			
			

		}

		
	}
	}
}

