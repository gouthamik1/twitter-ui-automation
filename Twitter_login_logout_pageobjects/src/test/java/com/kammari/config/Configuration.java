package com.kammari.config;


import com.kammari.util.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

//TODO : For now, let's keep things simple by putting these settings here in code
//We will move these to a configuration file later
class Configuration {

    public static BrowserType Browser = BrowserType.UseDefault;
    public static int TimeOut = 8;
    public static WebDriver driver = null;

    private static boolean KeepBrowserOpenAfterTestRun = false;


    //TODO we will move this out of code in a later exercise
    private static String DriverDirectory = "C:\\Program Files\\SeleniumDrivers\\";

    public static WebDriver ConfigureDriver() throws Exception {

        //TODO: move these driver properties to configuration / command line in a later exercise
        //Chrome
        System.setProperty("webdriver.chrome.driver", DriverDirectory + "chromedriver.exe");
        //IE
        System.setProperty("webdriver.ie.driver", DriverDirectory + "IEDriverServer.exe");
        //Firefox
        System.setProperty("webdriver.gecko.driver", DriverDirectory + "geckodriver.exe");

        switch(Configuration.Browser) {
            case Chrome:
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            default:
                //We only support Chrome, IE, Firefox. We default to Chrome
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(AppConfiguration.TimeOut, TimeUnit.SECONDS);
        return driver;
    }

    public static void ExitDriver() {
        if(!KeepBrowserOpenAfterTestRun && driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

