package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class RegisterStep {
	private String btn_daftar = "//p[@class='pr-4 sigil-header__nav-action bl-text bl-text--body-small bl-text--semi-bold']";	
	private String input_email = "//input[@class=\'bl-text-field__input\']";
	private String btn_daftar2 = "//button[@class=\"mb-8 bl-button bl-button--primary bl-button--medium bl-button--block\"]";
	private String pop_up_verifikasi_email = "//p[@class=\"bl-text bl-text--subheading-3 bl-text--semi-bold\"]";
	private String btn_verifikasi = "//span[@class=\"bl-text bl-text--body-default bl-text--semi-bold bl-text--inverse\"]";
	private String page_daftar_dulu = "//p[@class=\"mt-48 mb-8 bl-text bl-text--subheading-1 bl-text--center bl-text--semi-bold\"]";
	private String input_nama = "/html/body/main/div/div[2]/section/div[1]/div[1]/div/input";
	private String input_password = "/html/body/main/div/div[2]/section/div[2]/div[1]/div/input";
	private String btn_simpan = "//button[@class=\"mb-128 bl-button bl-button--primary bl-button--medium bl-button--block\"]";
	private String success_create = "//p[@class=\"mb-12 bl-text bl-text--subheading-2 bl-text--semi-bold\"]";
	private String btn_lanjut = "//button[@class=\"mb-64 bl-button bl-button--primary bl-button--medium bl-button--block\"]";
	
	private String url = "https://www.bukalapak.com/";
	
	WebDriver driver = null;

	@Given("^user go to daftar page$")
	public void user_go_to_daftar_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Fioni/eclipse-workspace/CucumberJava/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath(btn_daftar)).click();
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		assertTrue(actualTitle.contains("Daftar Akun Bukalapak | Bukalapak"));
	}

	@When("^user input email address$")
	public void user_input_email_address() {	
		driver.findElement(By.xpath(input_email)).sendKeys("fionisarnen@gmail.com"+Keys.ENTER);
	}

	@And("^click kirim kode$")
	public void click_kirim_kode() throws InterruptedException {
		String actualString1 = driver.findElement(By.xpath(pop_up_verifikasi_email)).getText();
		assertTrue(actualString1.contains("Verifikasi Pendaftaran"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(btn_daftar2)).click();
	}

	@And("^user input secret code$")
	public void user_input_secret_code() throws InterruptedException {
		//user manually input kode rahasia
		Thread.sleep(10000);
		driver.findElement(By.xpath(btn_verifikasi)).click();
		Thread.sleep(5000);
	}
	
	@And("^user fill registeration$")
	public void user_fill_registeration() throws InterruptedException {
		String actualString2 = driver.findElement(By.xpath(page_daftar_dulu)).getText();
		assertTrue(actualString2.contains("Daftar dulu, yuk"));
		driver.findElement(By.xpath(input_nama)).sendKeys("Fionisar");
		driver.findElement(By.xpath(input_password)).sendKeys("Qa123456");
		driver.findElement(By.xpath(btn_simpan)).click();
		Thread.sleep(5000);
		
	}
	@Then("^user go to homepage$")
	public void user_go_to_homepage() throws InterruptedException {
		String actualString3 = driver.findElement(By.xpath(success_create)).getText();
		assertTrue(actualString3.contains("Kamu berhasil buat akun!"));
		driver.findElement(By.xpath(btn_lanjut)).click();
		Thread.sleep(5000);
		String actualTitle2 = driver.getTitle();
		assertTrue(actualTitle2.contains("Situs Belanja Online dan Jual Beli Mudah Terpercaya | Bukalapak"));
		driver.close();

	}
	
}
