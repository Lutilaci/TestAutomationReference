package test;

import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class LoginTest{

    LoginPage loginPage;

    final String WRONG_USER_NAME = "wrongUserName";
    final String WRONG_PASSWORD = "wrongPassword";

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.openUrl("/login.jsp");
    }

    @AfterEach
    public void logout(){
        loginPage.logout();
    }

    @AfterAll
    public static void tearDown(){quit();}

    @Test
    public void logInSuccessful(){
        loginPage.login();
        loginPage.validateSuccessfulLogin();
    }

    @Test
    public void logInUnregistered(){
        loginPage.loginWithDifferentValue(WRONG_USER_NAME, WRONG_PASSWORD);
        loginPage.validateSuccessfulLogin();
    }
}