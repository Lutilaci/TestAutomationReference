package test;

import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.net.MalformedURLException;

import static com.codecool.testautomation.config.DriverSingleton.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest{

    LoginPage loginPage;

    private static final String FAIL_TEST_DATA_SOURCE = "/login_fail.csv";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        loginPage = new LoginPage();
        loginPage.openUrl("/login.jsp");
    }

    @AfterAll
    public static void tearDown(){quit();}

    @Test
    public void logInSuccessful(){
        loginPage.login();
        loginPage.validateSuccessfulLogin();
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = FAIL_TEST_DATA_SOURCE, numLinesToSkip = 1)
//    void loginFail(String username, String password, String errorId) {
//        loginPage.loginWithDifferentValue(username, password);
//        boolean errormessagePresent = loginPage.validateErrorMessage(errorId);
//        assertTrue(errormessagePresent);
//    }
}