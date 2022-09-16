package com.codecool.testautomation.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverSingleton {

    private static WebDriver driver = null;

    private DriverSingleton(){}

    public static WebDriver getDriver() throws MalformedURLException {

        if (driver == null) {
            DesiredCapabilities capability = new DesiredCapabilities();

            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"), capability);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    public static void quit(){
        driver.quit();
        driver = null;
    }
}
