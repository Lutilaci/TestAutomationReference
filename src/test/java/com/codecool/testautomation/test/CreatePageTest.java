 package com.codecool.testautomation.test;

import com.codecool.testautomation.page.CreatePage;
import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.config.DriverSingleton.*;
import static com.codecool.testautomation.keyword.Keywords.*;

public class CreatePageTest {
    static CreatePage createPage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        createPage = new CreatePage();
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

//     I can't create sub-task for COALA
    @Test
    public void createCOALASubTask() {
        openUrl("browse/COALA-130");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("COALA-130 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/COALA-130");
        createPage.restoreSubTask();
    }

//     I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask() {
        openUrl("browse/TOUCAN-132");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("TOUCAN-121 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/TOUCAN-121");
        createPage.restoreSubTask();
    }

    @Test
    public void createJETISubTask(){
        openUrl("browse/JETI-103");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("JETI-103 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/JETI-103");
        createPage.restoreSubTask();
    }

    @Test
    public void createNewIssue() {
        openUrl("secure/Dashboard.jspa");
        clickButton(createPage.mainCreateButton);
        createPage.createSpecificIssue("MTP", "Bug", "Happy Test");

        // Restore
        createPage.restoreIssue();
    }

    @Test
    public void createIssueWithEmptySummary(){
        openUrl("secure/Dashboard.jspa");
        createPage.createIssueWithEmptySummary();

        Assertions.assertEquals("You must specify a summary of the issue.", createPage.createIssueErrorMessage.getText());
        createPage.cancelCreation();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("COALA");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CreateIssueInJETIProjectWithIssueTypes() {
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("JETI");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    // I don't have permission to create TOUCAN project
    @Test
    public void CreateIssueInTOUCANProjectWithIssueTypes() {
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("TOUCAN");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CancelIssueAfterFill() {
        openUrl("secure/Dashboard.jspa");
        clickButton(createPage.mainCreateButton);
        createPage.fillOutCreation("MTP", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        createPage.validateIssueDoesntExist();

        Assertions.assertEquals("No issues were found to match your search", createPage.resultPageContent.getText());
    }
}
