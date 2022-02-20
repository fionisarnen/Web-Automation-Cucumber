package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class LoginStep {
	private String btn_login = "//a[@class=\"sigil-header__nav te-header-login\"]";
	private String input_email = "//input[@id=\"LoginID\"]";
	private String input_password = "//input[@id=\"Password\"]";
	private String btn_lanjut = "//button[@id=\"submit_button\"]";
	private String btn_signin = "//button[@id=\"btn-login\"]";
	private String icon_avatar = "//a[@class=\"sigil-header__nav-link\"]";
	private String name_of_user = "//a[@class=\"bl-link is-hide-underline\"]";
	private String banner_success_login = "//p[@class=\"bl-text bl-text--inverse bl-text--ellipsis__2\"]";

	private String url = "https://www.bukalapak.com/";

	WebDriver driver = null;

	@Given("^user go to login page$")
	public void user_go_to_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Fioni/eclipse-workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath(btn_login)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualTitle = driver.getTitle();
		assertTrue(actualTitle.contains("Accounts"));
	}

	@When("^user fill email address$")
	public void user_fill_email_address() {
		driver.findElement(By.xpath(input_email)).sendKeys("fiosarnen999@gmail.com");
		driver.findElement(By.xpath(btn_lanjut)).click();
	}

	@And("^user fill password$")
	public void user_fill_password() {
		driver.findElement(By.xpath(input_password)).sendKeys("Qa123456");
	}

	@And("^user click button login$")
	public void user_click_button_login() {
		driver.findElement(By.xpath(btn_signin)).click();
	}

	@Then("^user has logged in$")
	public void user_has_logged_in() throws InterruptedException {
		//driver.findElement(By.xpath(icon_avatar)).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//String actualString1 = driver.findElement(By.xpath(name_of_user)).getText();
		//assertTrue(actualString1.contains("Fioni"));
		//Thread.sleep(000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
		By elem_dynamic = By.xpath(banner_success_login);
		wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
		if(driver.findElements(By.xpath(banner_success_login)).size() != 0){
			String actualString2 = driver.findElement(By.xpath(banner_success_login)).getText();
			assertTrue(actualString2.contains("Kamu telah Login sebagai fioni"));
			
		}
		driver.close();

	}

}