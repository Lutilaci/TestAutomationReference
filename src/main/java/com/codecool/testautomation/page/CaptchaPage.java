package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codecool.testautomation.keyword.Keywords.*;

public class CaptchaPage extends BasePage {
    LoginPage loginPage;

    By captcha = By.xpath("//div[@id='captcha']/div/img");
    @FindBy(id = "login-form-submit") public static WebElement logInButton;
    @FindBy(id = "login-form-username") public static WebElement usernameField;
    @FindBy(id = "login-form-password") public static WebElement passwordField;
    @FindBy(id = "captcha") public static WebElement captchaPicture;

    public CaptchaPage(){
        loginPage = new LoginPage();
    }

    public void TryLoginThreeTimesWithWrongPassword(String password) {
        for (int i = 0; i<3; i++)
        {
            loginPage.loginWithDifferentValue(loginPage.getUSER_NAME(), password);
            loginPage.login();
        }
    }

    public boolean ValidateCaptcha() {
        waitForWebElementToBePresent(captchaPicture);
        return driver.findElements(captcha).isEmpty();
    }

    public void fillUsernameAndPassword(String password){
        waitForElementToSendText(usernameField, loginPage.getUSER_NAME());
        passwordField.sendKeys(password);
    }
}
