package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.config.DriverSingleton.*;
import static com.codecool.testautomation.keyword.Keywords.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowseIssuesTest {
    static BrowsePage browsePage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        browsePage = new BrowsePage();
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterAll
    public void tearDown() {
        quit();
    }

    @Test
    public void browseIssues(){
        openUrl("projects/MTP/issues/MTP-2020?filter=allopenissues");
        Assertions.assertEquals("All issues", browsePage.subnavigatorTitle.getText());
        Assertions.assertEquals("Happy Path", browsePage.browseIssueHeader.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        openUrl("browse/TOUCAN-1");
        Assertions.assertEquals("TOUCAN-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        openUrl("browse/TOUCAN-2");
        Assertions.assertEquals("TOUCAN-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        openUrl("browse/TOUCAN-3");
        Assertions.assertEquals("TOUCAN-3", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID1(){
        openUrl("browse/JETI-1");
        Assertions.assertEquals("JETI-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID2(){
        openUrl("browse/JETI-2");
        Assertions.assertEquals("JETI-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID3(){
        openUrl("browse/JETI-3");
        Assertions.assertEquals("JETI-3", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        openUrl("browse/COALA-1");
        Assertions.assertEquals("COALA-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        openUrl("browse/COALA-2");
        Assertions.assertEquals("COALA-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        openUrl("browse/COALA-3");
        Assertions.assertEquals("COALA-3", browsePage.issueLink.getText());
    }
}
