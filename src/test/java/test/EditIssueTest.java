package test;

import com.codecool.testautomation.page.EditIssuePage;
import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class EditIssueTest {
    static EditIssuePage editIssuePage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp(){
        editIssuePage = new EditIssuePage();
        loginPage = new LoginPage();
        loginPage.login();
        editIssuePage.openUrl("browse/MTP-2096");
    }

    @AfterEach
    public void tearDown(){
        quit();
    }

    @Test
    public void editExistingIssue(){
        editIssuePage.waitForElementToClick(editIssuePage.editButton);
        editIssuePage.renameSummary("Happy Path Edit");
        editIssuePage.updateIssue();
        Assertions.assertEquals("Happy Path Edit", editIssuePage.getSummary());
    }

    @Test
    public void editIssueCancel(){
        editIssuePage.waitForElementToClick(editIssuePage.editButton);
        editIssuePage.renameSummary("Happy Path Edit");
        editIssuePage.cancelUpdate();
        Assertions.assertEquals("Happy Path", editIssuePage.getSummary());
    }

    @Test
    public void addField(){
        editIssuePage.waitForElementToClick(editIssuePage.editButton);
        editIssuePage.addDescription("new description");
        editIssuePage.updateIssue();
        Assertions.assertEquals("new description",editIssuePage.getDescription());

    }
}
