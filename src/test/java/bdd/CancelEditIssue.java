package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Can I have a review pls?

public class CancelEditIssue extends BasePage {

    @FindBy(css = ".buttons .aui-button-link") WebElement cancelChangesButton;
    @FindBy(id = "edit-issue") WebElement editButton;
    @FindBy (id = "login-form-password") WebElement passwordField;
    @FindBy(id = "summary") WebElement summaryField;
    @FindBy(id = "login-form-username") WebElement usernameField;
    @FindBy(id = "summary-val") WebElement summaryValue;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    @Given("As valid user I am logged-in to Jira")
    public void loginToJira(){
        openUrl("login.jsp");
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    @And("Navigate to MTP-2235")
    public void openIssuePage(){
        openUrl("browse/MTP-2235");
    }

    @When("I click to 'Edit' button")
    public void clickEditButton(){
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    @And("I change summary to 'Happy Path Cancel'")
    public void renameSummary(){
        wait.until(ExpectedConditions.elementToBeClickable(summaryField)).clear();
        summaryField.sendKeys("Happy Path Cancel");
    }

    @And("I click 'Cancel' button")
    public void cancelChanges(){
        cancelChangesButton.click();
    }

    @And("I accept alert window")
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    @When("I refresh the page")
    public void refreshPAge(){
        driver.navigate().refresh();
    }

    @Then("Expected summary is 'Happy Path'")
    public void validate(){
        Assertions.assertEquals("Happy Path", summaryValue.getText());
    }


}

