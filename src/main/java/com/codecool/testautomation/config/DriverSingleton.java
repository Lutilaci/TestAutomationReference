package com.codecool.testautomation.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverSingleton {

    private static WebDriver driver = null;

    private DriverSingleton(){}

    public static WebDriver getDriver() throws MalformedURLException {
        final String BROWSER = System.getProperty("BROWSER");
        final String PASSWORD = System.getProperty("PASSWORD");

        if (driver == null) {

            DesiredCapabilities capability = new DesiredCapabilities();
            if (BROWSER.equals("CHROME")) {
                capability.setBrowserName("chrome");
            } else if (BROWSER.equals("FIREFOX")) {
                capability.setBrowserName("firefox");
            }
            capability.setPlatform(Platform.LINUX);

            driver = new RemoteWebDriver(
                    new URL("https://selenium:" + PASSWORD + "@seleniumhub.codecool.metastage.net/wd/hub"), capability);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    public static void quit(){
        driver.quit();
        driver = null;
    }
}
