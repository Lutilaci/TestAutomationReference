package test;

import com.codecool.testautomation.page.LoginPage;
import com.codecool.testautomation.page.PermissionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codecool.testautomation.config.DriverSingleton.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PermissionsWithGlassTest {

    static PermissionsPage pPage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {

        pPage = new PermissionsPage();
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterAll
    public static void quitDriver() {
        quit();
    }

    @Test
    public void availableRequiredIssuesInPPProject() {
        pPage.OpenPPProjectSettings();
        assertTrue(pPage.validateSettingIssues(Arrays.asList("Bug","Epic","Story","Sub-task","Task")));
    }

    @Test
    public void hasAllPPProjectIssueTypesInGlass() {
        pPage.OpenPPProjectSettings();
        List<String> issuesInSetting = pPage.GetAllIssueTypesFromSettings();
        pPage.OpenPPProjectGlassPage();

        assertTrue(pPage.validateDropDown(issuesInSetting));
        assertTrue(pPage.validateIcons(issuesInSetting));
    }

    @Test
    public void CheckPermissionAccess() {
        pPage.OpenPPProjectGlassPage();

        pPage.goToPermissionsMatrix();
        assertTrue(pPage.validatePermissionsMatrix("Browse Projects", "Any logged in user"));

        pPage.goToViewBy();
        assertTrue(pPage.validateViewBy("Browse Projects", "Granted to"));
    }
}
