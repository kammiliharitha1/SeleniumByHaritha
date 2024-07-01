
package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class EbayAddToCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to eBay
            driver.get("https://www.ebay.com/");

            // Search for a specific category of items
            WebElement searchBox = driver.findElement(By.id("gh-ac"));
            searchBox.sendKeys("laptops");
            searchBox.submit();

            // Wait until the search results are loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='s-item__link']")));

            // Find all product items in the search results
            List<WebElement> products = driver.findElements(By.cssSelector("a[class='s-item__link']"));
            System.out.println("items are selected");

            for (int i = 0; i < Math.min(products.size(), 3); i++) {
                boolean isStale = true;
                int attempts = 0;
                while (isStale && attempts < 3) {
                    try {
                        // Refresh the list of products each time to avoid StaleElementReferenceException
                        products = driver.findElements(By.cssSelector("a[class='s-item__link']"));

                        // Click on the ith product to navigate to its details page
                        products.get(i).click();
                        System.out.println("Item "+i+"is clicked");

                        // Wait until the "Add to Cart" button is visible and click it
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atcBtn_btn_1")));
                        WebElement addToCartButton = driver.findElement(By.id("atcBtn_btn_1"));
                        addToCartButton.click();
                        

                        // Wait for a confirmation message or the cart page to ensure the item was added
                        wait.until(ExpectedConditions.textToBePresentInElement(addToCartButton, "View in cart"));

                        // Go back to the search results page
                        driver.navigate().back();

                        // Optionally, wait for the product list page to reload
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='s-item__link']")));

                        isStale = false; // If no exception, exit the loop
                    } catch (StaleElementReferenceException e) {
                        // Increment the attempts counter
                        attempts++;
                        System.out.println("StaleElementReferenceException caught. Attempt: " + attempts);
                    }
                }
            }

            // Print confirmation
            System.out.println("Added selected items to the cart successfully.");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
