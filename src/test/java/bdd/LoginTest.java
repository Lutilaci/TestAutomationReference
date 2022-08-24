package bdd;

import com.codecool.testautomation.page.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import java.util.Objects;

public class LoginTest extends BasePage {

    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    @Given("The user is on the login page")
    public void openLoginPage(){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    @When("I enter username {string}")
    public void enterUserName(String username){
        if (Objects.equals(username, "valid")){
            driver.findElement(By.id("login-form-username")).sendKeys(USER_NAME);
        } else if (Objects.equals(username, "invalid")){
            driver.findElement(By.id("login-form-username")).sendKeys("invalid");
        }
    }

    @And("I enter password {string}")
    public void enterPassword(String password){
        if (Objects.equals(password, "valid")) {
            driver.findElement(By.id("login-form-password")).sendKeys(PASSWORD);
        } else if (Objects.equals(password, "invalid")){
            driver.findElement(By.id("login-form-password")).sendKeys("invalid");
        }
    }

    @Then("I press login")
    public void submitLoginPAge(){
        driver.findElement(By.id("login-form-password")).submit();
    }

}
