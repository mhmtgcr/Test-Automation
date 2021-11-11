package guru.springframework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	WebDriver driver;
	//String productId = "123654" ;

//	@Test
//	public void test() {
//		WebDriverManager.chromedriver().setup();
//
//		WebDriver driver = new ChromeDriver();
//
//		driver.get("http://localhost:8089/");
//	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--allow--insecure-localhost");
		opt.addArguments("acceptInsecureCerts");
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--disable-notifications");
		opt.addArguments("disable-infobars");

		opt.addArguments("--headless");
		driver = new ChromeDriver();

	}

	@Test
	public void testConnection() {
		driver.get("http://localhost:8089/");

	}

	@Test
	public void testCreateProduct() {
		driver.findElement(By.linkText("Create Product")).click();

	}

	@Test(dependsOnMethods = { "testCreateProduct" })
	public void testProductDetails() {
		//driver.findElement(By.id("productId")).sendKeys(productId);

		driver.findElement(By.id("description")).sendKeys("Selenium");
		driver.findElement(By.id("price")).sendKeys("20");
		driver.findElement(By.id("imageUrl")).sendKeys("selenium image");
		driver.findElement(By.cssSelector("body > div > div:nth-child(4) > form > div.row > button")).submit();

	}

	@Test(dependsOnMethods = { "testProductDetails" })
	public void testGetId() {
	
		String id = driver.findElement(By.cssSelector("body > div > div:nth-child(4) > form > div:nth-child(1) > div > p")).getText();
		System.out.println("Product ID : " + id);

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
