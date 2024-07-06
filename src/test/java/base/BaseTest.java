package base;

import java.io.FileReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties p = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader frloc;
	public WebDriverWait wait;
	public Actions action;
	

	@BeforeTest
	public void setUpdata() throws IOException {

		FileReader fr = new FileReader(
				"C:\\SeleniumByHaritha\\TryCodingWithSelenium\\src\\test\\resources\\configFiles\\config.properties");
		p.load(fr);
		FileReader frLoc = new FileReader(
				"C:\\SeleniumByHaritha\\TryCodingWithSelenium\\src\\test\\resources\\configFiles\\locators.properties");

		loc.load(frLoc);

		if (p.getProperty("browser").equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p.getProperty("URL"));
			

		}

		else if (p.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p.getProperty("URL"));

		}

		else if (p.getProperty("browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(p.getProperty("URL"));

		}
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		action=new Actions(driver);
		System.out.println(driver+"is instantiated");
		Reporter.log(driver+"is instantiated");

	}

	
	
	
	
	
	
	  @AfterTest public void tearDown() {
	  System.out.println("Tear down successful"); 
	  Reporter.log("Tear down successful");
	  driver.close(); }
	 
	 
	 
	 
	 
	 
}
