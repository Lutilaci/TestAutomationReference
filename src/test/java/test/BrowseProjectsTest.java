package test;

import com.codecool.testautomation.page.BrowsePage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static com.codecool.testautomation.config.DriverSingleton.*;

public class BrowseProjectsTest {
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
    public void browseProjects() {
        browsePage.openUrl("secure/BrowseProjects.jspa");
        Assertions.assertEquals("Browse projects", browsePage.mainPageHeader.getText());
    }

    @Test
    public void openExistingProject(){
        browsePage.openUrl("projects/MTP/summary");
        browsePage.waitForWebElementToBePresent(browsePage.projectMetaValue);
        Assertions.assertEquals("MTP", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openCOALAProject(){
        browsePage.openUrl("projects/COALA/summary");
        Assertions.assertEquals("COALA", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openJETIProject(){
        browsePage.openUrl("projects/JETI/summary");
        Assertions.assertEquals("JETI", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openTOUCANProject(){
        browsePage.openUrl("projects/TOUCAN/summary");
        Assertions.assertEquals("TOUCAN", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openNonExistingProject() {
        browsePage.openUrl("projects/SOMETHING/summary");
        Assertions.assertEquals("You can't view this project", browsePage.pageError.getText());
    }
}
