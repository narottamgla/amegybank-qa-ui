package com.amegybank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(css = ".main-nav__login-button__label")
	private WebElement homePageLoginButton;

	@FindBy(css = "#personalForm input#publicCred1")
	private WebElement loginUserNameTxBx;

	@FindBy(css = "#personalForm input#privateCred1")
	private WebElement loginUserPasswordTxBx;

	@FindBy(css = "[data-aa-buttonclick='personal login']")
	private WebElement userLoginButton;

	@FindBy(css = "#personalForm #publicCred1-error")
	private WebElement invlaidUserNameErrorMsg;

	@FindBy(css = "#personalForm #privateCred1-error")
	private WebElement invlaidUserPasswordErrorMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHomePageLoginButton() {
		homePageLoginButton.click();
	}

	public void performLogin(String username, String password) {
		loginUserNameTxBx.clear();
		loginUserNameTxBx.sendKeys(username);
		loginUserPasswordTxBx.clear();
		loginUserPasswordTxBx.sendKeys(password);
		userLoginButton.click();
	}

	public String getValidatorErrorForUserName() {
		return invlaidUserNameErrorMsg.getText(); 
	}

	public String getValidatorErrorForUserPassword() {
		return invlaidUserPasswordErrorMsg.getText();
	}

}
