package com.codecool.testautomation.page;

import com.codecool.testautomation.config.DriverSingleton;
import com.codecool.testautomation.config.LoginSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    final String BASE_URL = System.getenv("BASE_URL");

    public BasePage(){
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void openUrl(String url){
        driver.get(BASE_URL + url);
    }

    public void waitForWebElementToBePresent(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));}

    public void waitForElementToSendText(WebElement webElement, String text){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);}

    public void waitForElementToClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();}

    public static void clickButton(WebElement webElement){webElement.click();}
}