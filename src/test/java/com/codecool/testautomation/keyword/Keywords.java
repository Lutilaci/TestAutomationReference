package com.codecool.testautomation.keyword;

import com.codecool.testautomation.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Keywords extends BasePage {

    static final String BASE_URL = System.getenv("BASE_URL");

    public static void openUrl(String url){
        driver.get(BASE_URL + url);
    }

    public static void clickButton(WebElement webElement){webElement.click();}

    public static void waitForWebElementToBePresent(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));}

    public static void waitForElementToSendText(WebElement webElement, String text){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);}

    public static void waitForElementToClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();}
}
