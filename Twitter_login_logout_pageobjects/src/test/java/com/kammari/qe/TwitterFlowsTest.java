package com.kammari.qe;

import com.kammari.config.AppConfiguration;
import com.kammari.pages.*;
import com.kammari.qe.base.FunctionalTest;
import org.junit.Test;

import com.kammari.util.WaitHelper;

import static junit.framework.TestCase.assertTrue;

public class TwitterFlowsTest extends FunctionalTest {

    @Test
    public void LoginAndLogout() throws Exception {

        HomePage homePage = new HomePage(driver);
        homePage.AtChecker();
        homePage.ClickOnLogin();
        WaitHelper.WaitForPageLoad();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.AtChecker();
        loginPage.EnterLoginPasswordAndSubmit(
                AppConfiguration.Email, AppConfiguration.Password );
        WaitHelper.WaitForPageLoad();
        loginPage.ClickOnLogin();
        WaitHelper.WaitForPageLoad();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.AtChecker();
        landingPage.ClickOnUserDropDown();
        WaitHelper.WaitForPageLoad();

        landingPage.ClickOnLogout();
        WaitHelper.WaitForPageLoad();

        //Check you are back on home page
        homePage.AtChecker();
    }
}