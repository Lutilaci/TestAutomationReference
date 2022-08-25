package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowseProjects extends BasePage {

    @FindBy(id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login-form-username") WebElement usernameField;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValue;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    @Before
    public void before_all(){
        openUrl("login.jsp");
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    @Given("Open project {string}")
    public void openProject(String project){

        openUrl("projects/" + project + "/summary");
    }

    @Then("Check is the current project is {string}")
    public void checkCurrentProject(String project){
        Assertions.assertEquals(project, projectMetaValue.getText());
    }
}
