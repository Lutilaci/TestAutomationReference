package com.codecool.testautomation.page;

import com.codecool.testautomation.config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage(){
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }
}