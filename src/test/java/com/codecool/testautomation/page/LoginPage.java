package com.codecool.testautomation.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codecool.testautomation.keyword.Keywords.*;

public class LoginPage extends BasePage{

    @FindBy(id = "login-form-username")
    WebElement userNameField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"header-details-user-fullname\"]//img")
    WebElement userProfilePicture;

    @FindBy(id = "login")
    WebElement loginSubmitButton;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login() {
        openUrl( "login.jsp");
        waitForWebElementToBePresent(userNameField);

        userNameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    public void loginSuccessful() {
        login();
        waitForWebElementToBePresent(userProfilePicture);
    }

    String validateSuccessfulLogin() {
        waitForWebElementToBePresent(userProfilePicture);
        String profilePictureAltString = userProfilePicture.getAttribute("alt");
        return profilePictureAltString;
    }

    boolean validateErrorMessage(String errorId) {
        waitForWebElementToBePresent(loginSubmitButton);
        WebElement errorMessage = driver.findElement(By.id(errorId));
        boolean isPresentErrorMessage = errorMessage.isDisplayed();
        return isPresentErrorMessage;
    }
}