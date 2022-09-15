package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

// Can I have a review pls?

public class LoginPage extends BasePage{

    @FindBy(css = ".aui-avatar-small img") public WebElement avatar;
    @FindBy(css = "#log_out") public WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/p[1]") public WebElement logoutMessage;
    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login-form-username") WebElement userNameField;
    @FindBy(xpath = "//*[@id=\"header-details-user-fullname\"]//img") WebElement userProfilePicture;
    @FindBy(css = "#login") public WebElement loginButton;

    public LoginPage() throws MalformedURLException {}

    public void login() {
        openUrl( "login.jsp");
        waitForWebElementToBePresent(userNameField);

        userNameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        submitLogin();

        waitForWebElementToBePresent(userProfilePicture);
    }

//    public void loginWithDifferentValue(String username, String password){
//        openUrl( "login.jsp");
//        waitForWebElementToBePresent(userNameField);
//
//        userNameField.sendKeys(nullToEmptyString(username));
//        passwordField.sendKeys(nullToEmptyString(password));
//        submitLogin();
//    }


    public String validateSuccessfulLogin() {
        waitForWebElementToBePresent(userProfilePicture);
        String profilePictureAltString = userProfilePicture.getAttribute("alt");
        return profilePictureAltString;
    }

    public void logout(){
        avatar.click();
        logoutButton.click();
    }

    public boolean validateErrorMessage(String errorId) {
//        waitForWebElementToBePresent(loginButton);
        WebElement errorMessage = driver.findElement(By.className(errorId));
        boolean isPresentErrorMessage = errorMessage.isDisplayed();
        return isPresentErrorMessage;
    }

    public void submitLogin(){
        passwordField.submit();
    }
}