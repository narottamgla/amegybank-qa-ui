package com.amegybank.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amegybank.pages.HomePage;
import com.amegybank.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginLogoutSteps {

	static WebDriver driver;
	static HomePage homePage;
	static LoginPage loginPage;

	@Given("^User open amegybank page urlin browser$")
	public void User_open_amegybank_page_urlin_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amegybank.com/");
	}

	@Then("^User should navigate to amegybank home page$")
	public void User_should_navigate_to_amegybank_home_page() throws Throwable {
		homePage = new HomePage(driver);
		System.out.println("User should navigate to amegybank home page");
		Assert.assertTrue(homePage.isUserNavigatedToHomePage());
	}

	@Then("^User should see home page title as \"([^\"]*)\"$")
	public void User_should_see_home_page_title_as(String pageTitle) throws Throwable {
		Assert.assertEquals(homePage.getPageTitle(), pageTitle);

	}

	@Then("^User should see different top left menu options$")
	public void User_should_see_different_top_left_menu_options(DataTable dataTable) throws Throwable {
		List<String> optionList = dataTable.asList(String.class);
		Assert.assertEquals(optionList, homePage.getTopLeftSideHomePageNaviagtionOptions());
	}

	@Then("^User should see different top right menu options$")
	public void User_should_see_different_top_right_menu_options(DataTable dataTable) throws Throwable {
		List<String> optionList = dataTable.asList(String.class);
		Assert.assertEquals(optionList, homePage.getTopRightSideHomePageNaviagtionOptions());
	}
	
	@When("User clicks on Login Button on amegybank home page")
	public void user_clicks_on_Login_Button_on_amegybank_home_page() {
		loginPage = new LoginPage(driver);
	}

	@Then("User should see login page")
	public void user_should_see_login_page() {
		loginPage.clickHomePageLoginButton();
	}
	
	@When("User performs login with username as {string} and password as {string}")
	public void user_performs_login_with_username_as_and_password_as(String username, String password) {
		loginPage.performLogin(username, password);
	}

	@Then("User should see username validation error as {string} and password validator error as {string}")
	public void user_should_see_username_validation_error_as_and_password_validator_error_as(String string, String string2) {
	}
	@Then("User quite the browser tab$")
	public void User_quit_the_browser() throws Throwable {
		driver.quit();
	}
}
