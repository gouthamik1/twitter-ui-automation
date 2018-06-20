package com.kammari.pages;

import com.kammari.config.AppConfiguration;
import com.kammari.pages.base.BasePage;
import com.kammari.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	@FindBy(css = "#user-dropdown-toggle")
	private WebElement UserDropDownLink;

	@FindBy(css = ".dropdown-link")
	private WebElement LogoutLink;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void AtChecker() throws Exception{
		DriverHelper.AssertPageTitleContains("Twitter");
		DriverHelper.AssertPageUrlStartsWith(AppConfiguration.BaseUrl);
	}

	public void ClickOnUserDropDown(){ UserDropDownLink.click();}

	public void ClickOnLogout() {
		LogoutLink.click();
	}

}
