package test;

import com.codecool.testautomation.page.BrowsePage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class BrowseIssuesTest{
    static BrowsePage browsePage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        browsePage = new BrowsePage();
        browsePage.login();
    }

    @AfterAll
    public static void tearDown() {
        quit();
    }

    @Test
    public void browseIssues(){
        browsePage.openUrl("projects/MTP/issues/MTP-2235?filter=allissues");
        Assertions.assertEquals("All issues", browsePage.subnavigatorTitle.getText());
        browsePage.waitForWebElementToBePresent(browsePage.browseIssueHeader);
        Assertions.assertEquals("Happy Path", browsePage.browseIssueHeader.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        browsePage.openUrl("browse/TOUCAN-1");
        Assertions.assertEquals("TOUCAN-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        browsePage.openUrl("browse/TOUCAN-2");
        Assertions.assertEquals("TOUCAN-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        browsePage.openUrl("browse/TOUCAN-3");
        Assertions.assertEquals("TOUCAN-3", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID1(){
        browsePage.openUrl("browse/JETI-1");
        Assertions.assertEquals("JETI-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID2(){
        browsePage.openUrl("browse/JETI-2");
        Assertions.assertEquals("JETI-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckJETIIssueWithID3(){
        browsePage.openUrl("browse/JETI-3");
        Assertions.assertEquals("JETI-3", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        browsePage.openUrl("browse/COALA-1");
        Assertions.assertEquals("COALA-1", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        browsePage.openUrl("browse/COALA-2");
        Assertions.assertEquals("COALA-2", browsePage.issueLink.getText());
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        browsePage.openUrl("browse/COALA-3");
        Assertions.assertEquals("COALA-3", browsePage.issueLink.getText());
    }
}
