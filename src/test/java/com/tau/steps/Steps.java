package com.tau.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Steps {
	private WebDriver driver;
	@Before
	public void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	
	@Given("I am in the login page of the Para Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	    
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials(DataTable table) {
		List <String> loginForm = table.asList();
		driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
		driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
		driver.findElement(By.name("username")).submit();

	}

	@Then("I should be taken to the Overview page")
	public void i_should_be_taken_to_the_Overview_page() {
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).isDisplayed();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

	}

	@After
	public void tearDown (){
		driver.quit();

	}

}
