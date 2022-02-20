package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStep {
	private String btn_login = "//a[@class=\"sigil-header__nav te-header-login\"]";
	private String input_email = "//input[@id=\"LoginID\"]";
	private String input_password = "//input[@id=\"Password\"]";
	private String btn_lanjut = "//button[@id=\"submit_button\"]";
	private String btn_signin = "//button[@id=\"btn-login\"]";
	private String product_card = "//div[@class=\"bl-product-card__description\"]";
	private String search_box = "//input[@id=\"v-omnisearch__input\"]";
	private String btn_tambah_ke = "//button[@class=\"bl-button bl-button--ghost bl-button--small bl-button--block\"]";
	private String pop_up_cart = "//div[@class=\"cart-menu-popover__content\"]";
	
	private String url = "https://www.bukalapak.com/";

	WebDriver driver = null;
	
	@Given("^user is on bukalapak homepage$")
	public void user_is_on_bl_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Fioni/eclipse-workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath(btn_login)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualTitle = driver.getTitle();
		assertTrue(actualTitle.contains("Accounts"));
		driver.findElement(By.xpath(input_email)).sendKeys("fiosarnen999@gmail.com");
		driver.findElement(By.xpath(btn_lanjut)).click();
		driver.findElement(By.xpath(input_password)).sendKeys("Qa123456");
		driver.findElement(By.xpath(btn_signin)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("^user search for product$")
	public void user_search_for_product() {
		driver.findElement(By.xpath(search_box)).sendKeys("Masker"+Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("^user add product to cart$")
	public void user_add_product_to_cart() {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath(product_card));
		actions.moveToElement(target).perform();
		driver.findElement(By.xpath(btn_tambah_ke)).click();
		if(driver.findElements(By.xpath(pop_up_cart)).size() != 0){
			System.out.println("Succesfully add one product to cart");
		}
		driver.close();
	}
}