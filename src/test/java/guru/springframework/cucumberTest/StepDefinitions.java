package guru.springframework.cucumberTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	
	WebDriver driver;
	WebElement searchBox;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--allow--insecure-localhost");
		opt.addArguments("acceptInsecureCerts");
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--disable-notifications");
		opt.addArguments("disable-infobars");

		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
	}
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		
	}
	@When("navigate to spring boot web on the browser")
	public void navigate_to_spring_boot_web_on_the_browser() {
		driver.get("http://localhost:8089/");
	}
	@Then("click the create product button")
	public void click_the_create_product_button() {
		driver.findElement(By.linkText("Create Product")).click();
	}
	@Then("fill the description box")
	public void fill_the_description_box() {
		driver.findElement(By.id("description")).sendKeys("Cucumber");
	}
	@Then("fill the price box")
	public void fill_the_price_box() {
		driver.findElement(By.id("price")).sendKeys("20");
	}
	@Then("fill the image url box")
	public void fill_the_image_url_box() {
		driver.findElement(By.id("imageUrl")).sendKeys("cucumber image");
	}
	@Then("click the submit button")
	public void click_the_submit_button() {
		driver.findElement(By.cssSelector("body > div > div:nth-child(4) > form > div.row > button")).submit();

	}
	@Then("get the product id")
	public void get_the_product_id() {
		String id = driver.findElement(By.cssSelector("body > div > div:nth-child(4) > form > div:nth-child(1) > div > p")).getText();
		System.out.println("Product ID : " + id);
	}
	
	@After
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
