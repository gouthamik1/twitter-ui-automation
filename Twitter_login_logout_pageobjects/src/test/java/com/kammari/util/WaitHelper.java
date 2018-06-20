package com.kammari.util;

import com.kammari.config.AppConfiguration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    //Currently, this is used to wait for a new page to load
    public static void WaitForPageLoad() {

        new WebDriverWait(AppConfiguration.driver, AppConfiguration.TimeOut).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    //Currently, this is used to wait for ajax calls to finish
    public static void WaitForAjaxComplete() {

        new WebDriverWait(AppConfiguration.driver, AppConfiguration.TimeOut).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active"));
    }

}
