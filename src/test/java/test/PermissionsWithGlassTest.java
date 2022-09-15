package test;

import com.codecool.testautomation.page.PermissionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codecool.testautomation.config.DriverSingleton.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermissionsWithGlassTest{

    static PermissionsPage permissionsPage;

    @BeforeAll
    public static void setUp() {

        permissionsPage = new PermissionsPage();
        permissionsPage.login();
    }

    @AfterAll
    public static void quitDriver() {
        quit();
    }

    @Test
    public void availableRequiredIssuesInPPProject() {
        permissionsPage.OpenPPProjectSettings();
        assertTrue(permissionsPage.validateSettingIssues(Arrays.asList("Bug","Epic","Story","Sub-task","Task")));
    }

    @Test
    public void hasAllPPProjectIssueTypesInGlass() {
        permissionsPage.OpenPPProjectSettings();
        List<String> issuesInSetting = permissionsPage.GetAllIssueTypesFromSettings();
        permissionsPage.OpenPPProjectGlassPage();

        assertTrue(permissionsPage.validateDropDown(issuesInSetting));
        assertTrue(permissionsPage.validateIcons(issuesInSetting));
    }

    @Test
    public void CheckPermissionAccess() {
        permissionsPage.OpenPPProjectGlassPage();

        permissionsPage.goToPermissionsMatrix();
        assertTrue(permissionsPage.validatePermissionsMatrix("Browse Projects", "Any logged in user"));

        permissionsPage.goToViewBy();
        assertTrue(permissionsPage.validateViewBy("Browse Projects", "Granted to"));
    }
}
