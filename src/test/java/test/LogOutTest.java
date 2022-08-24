package test;

import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.testautomation.config.DriverSingleton.quit;

public class LogOutTest{

    static LoginPage loginPage;

    @BeforeAll
    public static void setUp(){
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterAll
    public static void quitDriver(){
        quit();
    }

    @Test
    public void successfulLogOut() {
        loginPage.logout();
        Assertions.assertEquals(loginPage.logoutMessage.getText(), "You are now logged out. Any automatic login has also been stopped.");
    }

}
