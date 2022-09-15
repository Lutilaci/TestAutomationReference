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

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public final String BASE_URL = System.getProperty("BASE_URL");
    public final String USER_NAME = System.getProperty("USER_NAME");
    public final String PASSWORD = System.getProperty("PASSWORD");

    @FindBy(id = "login-form-password") public WebElement passwordField;
    @FindBy(id = "login-form-username") public WebElement userNameField;

    public BasePage() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void login(){
        System.out.println(USER_NAME + PASSWORD);
        openUrl( "login.jsp");

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