package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditExistingIssue extends BasePage {

    @FindBy(id = "description") public WebElement descriptionField;
    @FindBy(id = "edit-issue") public WebElement editButton;
    @FindBy (id = "login-form-password") WebElement passwordField;
    @FindBy(id = "summary") public WebElement summaryField;
    @FindBy(id = "summary-val") public WebElement summaryValue;
    @FindBy(xpath = "//*[@id=\"description-wiki-edit\"]/nav/div/div/ul/li[2]/button") public WebElement switchTextMode;
    @FindBy(id = "edit-issue-submit") public WebElement updateButton;
    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div") public WebElement updateSuccessMessage;
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

    @Given("You are logged in and open 'MTP-2235' issue")
    public void openUrl(){
        openUrl("browse/MTP-2235");
        }

    @When("You click on 'Edit' button")
    public void clickEditButton(){
            wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    @And("Rename the summary to 'Happy Path Edit'")
    public void renameSummary(){
        wait.until(ExpectedConditions.visibilityOf(summaryField)).clear();
        summaryField.sendKeys("Happy Path Edit");
    }

    @And("Update the issue")
    public void updateIssue(){
        updateButton.click();
        wait.until(ExpectedConditions.visibilityOf(updateSuccessMessage));
    }

    @Then("The summary should be changed to 'Happy Path Edit'")
    public void validateResult(){
        Assertions.assertEquals("Happy Path Edit", summaryValue.getText());
    }

    @Then("Restore changes")
    public void restore(){
        clickButton(editButton);
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).clear();
        waitForElementToSendText(summaryField, "Happy Path");
        waitForElementToClick(switchTextMode);
        descriptionField.clear();
        summaryField.submit();
    }



}
