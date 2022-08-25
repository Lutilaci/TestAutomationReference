package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditIssuesInJETIProject extends BasePage{

    @FindBy(id = "edit-issue") public WebElement editButton;
    @FindBy (id = "login-form-password") WebElement passwordField;
    @FindBy(id = "login-form-username") WebElement usernameField;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    @Before
    public void before_all(){
        openUrl("login.jsp");
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    @Given("Open issue {string}")
    public void openIssue(String issueId){
        openUrl("projects/JETI/issues/" + issueId);
    }

    @Then("I see the 'Edit' button")
    public void isEditButtonVisible(){
        wait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.isDisplayed();
    }
}
