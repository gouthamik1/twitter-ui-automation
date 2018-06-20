
package com.kammari.qe.base;

import com.kammari.config.AppConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * <strong>FunctionalTest</strong> handles setup and teardown of WebDriver.
 */
public class FunctionalTest {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception{
		driver = AppConfiguration.ConfigureDriver();
		driver.get(AppConfiguration.BaseUrl);
	}
	
	@AfterClass
	public static void tearDown(){
		AppConfiguration.ExitDriver();
	}	
}
