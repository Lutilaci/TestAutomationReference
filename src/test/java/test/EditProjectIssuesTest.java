package test;

import com.codecool.testautomation.page.EditIssuePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.codecool.testautomation.config.DriverSingleton.quit;

public class EditProjectIssuesTest {
    static EditIssuePage editIssuePage;

    @BeforeAll
    public static void setUp(){
        editIssuePage = new EditIssuePage();
        editIssuePage.login();
    }

    @AfterAll
    public static void tearDown(){
        quit();
    }

    @Test
    public void checkTOUCAN1IssueEditable(){
        editIssuePage.openUrl("projects/TOUCAN/issues/TOUCAN-1");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkTOUCAN2IssueEditable(){
        editIssuePage.openUrl("projects/TOUCAN/issues/TOUCAN-2");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkTOUCAN3IssueEditable(){
        editIssuePage.openUrl("projects/TOUCAN/issues/TOUCAN-3");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkJETI1IssueEditable(){
        editIssuePage.openUrl("projects/JETI/issues/JETI-1");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkJETI2IssueEditable(){
        editIssuePage.openUrl("projects/JETI/issues/JETI-2");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkJETI3IssueEditable(){
        editIssuePage.openUrl("projects/JETI/issues/JETI-3");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkCOALA1IssueEditable(){
        editIssuePage.openUrl("projects/COALA/issues/COALA-1");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkCOALA2IssueEditable(){
        editIssuePage.openUrl("projects/COALA/issues/COALA-2");
        assertTrue(editIssuePage.editButtonIsPresent());
    }

    @Test
    public void checkCOALA3IssueEditable(){
        editIssuePage.openUrl("projects/COALA/issues/COALA-3");
        assertTrue(editIssuePage.editButtonIsPresent());
    }
}
