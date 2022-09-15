 package test;

import com.codecool.testautomation.page.CreatePage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class CreatePageTest {
    static CreatePage createPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        createPage = new CreatePage();
        createPage.login();
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

//     I can't create sub-task for COALA
    @Test
    public void createCOALASubTask() {
        createPage.openUrl("browse/COALA-130");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("COALA-130 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        createPage.openUrl("browse/COALA-130");
        createPage.restoreSubTask();
    }

//     I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask() {
        createPage.openUrl("browse/TOUCAN-132");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("TOUCAN-121 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        createPage.openUrl("browse/TOUCAN-121");
        createPage.restoreSubTask();
    }

    @Test
    public void createJETISubTask(){
        createPage.openUrl("browse/JETI-103");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("JETI-103 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskTableFirstRow.getText());

        // Restore
        createPage.openUrl("browse/JETI-103");
        createPage.restoreSubTask();
    }

    @Test
    public void createNewIssue() {
        createPage.openUrl("secure/Dashboard.jspa");
        createPage.createSpecificIssue("MTP", "Bug", "Happy Test");

        // Restore
        createPage.restoreIssue();
    }

    @Test
    public void createIssueWithEmptySummary(){
        createPage.openUrl("secure/Dashboard.jspa");
        createPage.createIssueWithEmptySummary();

        Assertions.assertEquals("You must specify a summary of the issue.", createPage.createIssueErrorMessage.getText());
        createPage.cancelCreation();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        createPage.clickCreateButton();
        createPage.setProjectTo("COALA");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CreateIssueInJETIProjectWithIssueTypes() {
        createPage.clickCreateButton();
        createPage.setProjectTo("JETI");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    // I don't have permission to create TOUCAN project
    @Test
    public void CreateIssueInTOUCANProjectWithIssueTypes() {
        createPage.clickCreateButton();
        createPage.setProjectTo("TOUCAN");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CancelIssueAfterFill() {
        createPage.clickCreateButton();
        createPage.fillOutCreation("MTP", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        createPage.validateIssueDoesntExist("Issue Cancel Test");

        Assertions.assertEquals("No issues were found to match your search", createPage.resultPageContent.getText());
    }
}
