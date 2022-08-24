package test;

import com.codecool.testautomation.page.EditIssuePage;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class EditIssueTest{
    static EditIssuePage editIssuePage;

    @BeforeAll
    public static void setUp(){
        editIssuePage = new EditIssuePage();
        editIssuePage.login();
        editIssuePage.openUrl("browse/MTP-2235");
    }

    @AfterAll
    public static void tearDown(){
        quit();
    }

    @Test
    public void editExistingIssue(){
        editIssuePage.waitForElementToClick(editIssuePage.editButton);
        editIssuePage.renameSummary("Happy Path Edit");
        editIssuePage.updateIssue();
        Assertions.assertEquals("Happy Path Edit", editIssuePage.getSummary());

        // Restore
        editIssuePage.restoreChanges();
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
