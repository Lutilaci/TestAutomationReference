package com.codecool.testautomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login-form-username") WebElement userNameField;
    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"header-details-user-fullname\"]//img") WebElement userProfilePicture;
    @FindBy(css = ".aui-avatar-small img") public WebElement avatar;
    @FindBy(css = "#log_out") public WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/p[1]") public WebElement logoutMessage;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    public LoginPage() {
    }

    public void login() {
        openUrl( "login.jsp");
        waitForWebElementToBePresent(userNameField);

        userNameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        submitLogin();

        waitForWebElementToBePresent(userProfilePicture);
    }

    public void loginWithDifferentValue(String username, String password){
        openUrl( "login.jsp");
        waitForWebElementToBePresent(userNameField);

        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitLogin();
        waitForWebElementToBePresent(userProfilePicture);
    }


    public String validateSuccessfulLogin() {
        waitForWebElementToBePresent(userProfilePicture);
        String profilePictureAltString = userProfilePicture.getAttribute("alt");
        return profilePictureAltString;
    }

    public void logout(){
        avatar.click();
        logoutButton.click();
    }

    public void submitLogin(){
        passwordField.submit();
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }
}