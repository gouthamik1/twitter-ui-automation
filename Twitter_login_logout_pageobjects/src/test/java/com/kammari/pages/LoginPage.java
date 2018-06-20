package com.kammari.pages;

import com.kammari.config.AppConfiguration;
import com.kammari.pages.base.BasePage;
import com.kammari.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css="form.signin .js-username-field")
	private WebElement EmailTextbox;
	
	@FindBy(css="form.signin .js-password-field")
	private WebElement PasswordTextbox;

	@FindBy(css="form.signin .submit")
	private WebElement LoginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void AtChecker() throws Exception{
		DriverHelper.AssertPageTitleContains("Twitter");
		DriverHelper.AssertPageUrlStartsWith(AppConfiguration.BaseUrl);
	}

	public void EnterLoginPasswordAndSubmit(String Email, String Password) {
		EmailTextbox.sendKeys(Email);
		PasswordTextbox.sendKeys(Password);
	}

	public void ClickOnLogin() {
		LoginButton.click();
	}
}
