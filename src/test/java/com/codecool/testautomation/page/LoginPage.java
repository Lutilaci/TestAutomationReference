package com.codecool.testautomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codecool.testautomation.keyword.Keywords.*;

public class LoginPage extends BasePage{

    @FindBy(id = "login-form-username") WebElement userNameField;
    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"header-details-user-fullname\"]//img") WebElement userProfilePicture;
    @FindBy(css = ".aui-avatar-small img") public WebElement avatar;
    @FindBy(css = "#log_out") public WebElement logoutButton;

    final String USER_NAME = System.getenv("USERNAME");
    final String PASSWORD = System.getenv("PASSWORD");

    public LoginPage() {
    }

    public void login() {
        openUrl( "login.jsp");
        waitForWebElementToBePresent(userNameField);
        System.out.println(USER_NAME);
        System.out.println(PASSWORD);

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

    public void logout(){
        avatar.click();
        logoutButton.click();
    }
}