package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

// Can I have a review pls?

public class LoginTest extends BasePage {

    @FindBy (className = "aui-message-error") WebElement errorMessage;
    @FindBy (id = "login-form-password") WebElement passwordField;
    @FindBy (id = "login-form-username") WebElement usernameField;

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    String username;
    String password;

    @Given("The user is on the login page")
    public void openLoginPage(){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    @When("I enter username {string}")
    public void enterUserName(String username){
        if (Objects.equals(username, "valid")){
            usernameField.sendKeys(USER_NAME);
        } else if (Objects.equals(username, "invalid")){
            this.username = username;
            usernameField.sendKeys("invalid");
        }
    }

    @And("I enter password {string}")
    public void enterPassword(String password){
        if (Objects.equals(password, "valid")) {
            passwordField.sendKeys(PASSWORD);
        } else if (Objects.equals(password, "invalid")){
            this.password = password;
            passwordField.sendKeys("invalid");
        }
    }

    @Then("I press login")
    public void submitLoginPAge(){

        driver.findElement(By.id("login-form-password")).submit();
        if (Objects.equals(username, "invalid") || Objects.equals(password, "invalid")){
            Assertions.assertEquals(errorMessage.getText(), "Sorry, your username and password are incorrect - please try again.");
        }
    }
}
