package com.kammari.pages;

import com.kammari.config.AppConfiguration;
import com.kammari.pages.base.BasePage;
import com.kammari.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(css = ".StaticLoggedOutHomePage-buttonLogin")
	private WebElement LoginLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void AtChecker() throws Exception{
		DriverHelper.AssertPageTitleContains("Twitter");
		DriverHelper.AssertPageUrlStartsWith(AppConfiguration.BaseUrl);
	}

	public void ClickOnLogin() {
		LoginLink.click();
	}

}
