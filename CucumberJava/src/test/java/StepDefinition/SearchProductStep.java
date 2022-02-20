package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStep {
	private String btn_login = "//a[@class=\"sigil-header__nav te-header-login\"]";
	private String input_email = "//input[@id=\"LoginID\"]";
	private String input_password = "//input[@id=\"Password\"]";
	private String btn_lanjut = "//button[@id=\"submit_button\"]";
	private String btn_signin = "//button[@id=\"btn-login\"]";
	private String search_box = "//input[@id=\"v-omnisearch__input\"]";
	private String page_search_result = "//h1[@class=\"bl-text--subheading-3 bl-text bl-heading bl-heading--h6\"]";
	private String product_1 = "//p[@class=\"bl-text bl-text--body-14 bl-text--ellipsis__2\"]";

	private String url = "https://www.bukalapak.com/";

	WebDriver driver = null;

	@Given("^user succesfully logged in and landed on homepage$")
	public void user_succes_logged_in_and_on_homepage() {
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

	@When("^user input keyword for product searching$")
	public void user_input_keyword_for_product_search() {
		driver.findElement(By.xpath(search_box)).sendKeys("Masker"+Keys.ENTER);
	}

	@Then("^user view search result$")
	public void user_view_result() throws InterruptedException {
		Thread.sleep(5000);
		String actualString1 = driver.findElement(By.xpath(page_search_result)).getText();
		assertTrue(actualString1.contains("Masker"));
		if(driver.findElements(By.xpath(product_1)).size() != 0){
			String actualString2 = driver.findElement(By.xpath(product_1)).getText();
			assertTrue(actualString2.contains("Masker"));
		}
		driver.close();
		
	}
}