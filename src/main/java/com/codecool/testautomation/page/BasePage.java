package com.codecool.testautomation.page;

import com.codecool.testautomation.config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

// Can I have a review pls?

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    final String BASE_URL = System.getProperty("BASE_URL");
    final String USER_NAME = System.getProperty("USER_NAME");
    final String PASSWORD = System.getProperty("PASSWORD");

    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login-form-username") WebElement userNameField;

    public BasePage() throws MalformedURLException {
        System.out.println(BASE_URL + PASSWORD + USER_NAME);
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void login(){
        openUrl( "login.jsp");
//        waitForWebElementToBePresent(userNameField);

        userNameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
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

//    public static String nullToEmptyString(String string) {
//        return Objects.requireNonNullElse(string, "");
//    }

}