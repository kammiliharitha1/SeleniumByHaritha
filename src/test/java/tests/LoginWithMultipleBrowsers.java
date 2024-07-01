package tests;


import base.BaseTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginWithMultipleBrowsers extends BaseTest {

	
	@Test
	public  void LoginTest() throws InterruptedException, IOException {
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(loc.getProperty("Username"))).sendKeys("standard_user");
		driver.findElement(By.xpath(loc.getProperty("Password"))).sendKeys("secret_sauce");
		driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();

	}

}
