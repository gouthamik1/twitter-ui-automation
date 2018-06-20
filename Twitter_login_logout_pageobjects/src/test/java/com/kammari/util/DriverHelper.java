package com.kammari.util;

import com.kammari.config.AppConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {

    public static boolean AssertElementIsAbsent(By by) throws Exception {
        WebDriver driver = AppConfiguration.driver;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return true;
        }
        throw new Exception(String.format("Element is expected to be absent but is present"));
    }

    public static boolean AssertPageTitleContains(String partialTitle) throws Exception {

        WebDriver driver = AppConfiguration.driver;

        boolean result = (new WebDriverWait(driver, AppConfiguration.TimeOut))
                .until(ExpectedConditions.titleContains(partialTitle));

        return result;
    }

    public static boolean AssertPageUrlStartsWith(String givenUrl) throws Exception {

        WebDriver driver = AppConfiguration.driver;
        String currUrl = driver.getCurrentUrl();
        boolean result = currUrl.toLowerCase().startsWith(givenUrl.toLowerCase());
        if(!result) {
            throw new Exception(String.format("%s does not start with %s", currUrl, givenUrl));
        }
        return result;
    }
}
