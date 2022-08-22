package com.codecool.testautomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.codecool.testautomation.keyword.Keywords.*;



public class EditIssuePage extends BasePage{

    @FindBy(id = "edit-issue") public WebElement editButton;
    @FindBy(id = "summary") public WebElement summaryField;
    @FindBy(id = "summary-val") public WebElement summaryValue;
    @FindBy(id = "description") public WebElement descriptionField;
    @FindBy(id = "description-val") public WebElement descriptionValue;
    @FindBy(id = "edit-issue-submit") public WebElement updateButton;
    @FindBy(xpath = "//*[@id=\"description-wiki-edit\"]/nav/div/div/ul/li[2]/button") public WebElement switchTextMode;
    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/footer/div/div/button") public WebElement cancelChangesButton;
    @FindBy(id = "fixVersions-textarea") public WebElement fixVersionsField;
    @FindBy(css = ".item-delete") public WebElement fixVersionDelete;
    @FindBy(id = "action_id_21") public WebElement inProgressButton;
    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div") public WebElement updateSuccessMessage;

    public EditIssuePage() {}

    public void clickEditIssue(){
        waitForElementToClick(editButton);
    }

    public void renameSummary(String summaryName){
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).clear();
        summaryField.sendKeys(summaryName);
    }

    public void updateIssue(){
        updateButton.click();
        waitForWebElementToBePresent(updateSuccessMessage);
    }

    public void cancelUpdate(){
        cancelChangesButton.click();
        driver.switchTo().alert().accept();
    }

    public String getSummary(){
        return summaryValue.getText();
    }

    public String getDescription(){
        return descriptionValue.getText();
    }

    public void restoreChanges(){
        clickButton(editButton);
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).clear();
        waitForElementToSendText(summaryField, "Happy Path");
        waitForElementToClick(switchTextMode);
        descriptionField.clear();
        summaryField.submit();
    }


    public void addDescription(String description){
        waitForElementToClick(switchTextMode);
        descriptionField.clear();
       waitForElementToSendText(descriptionField, description);
    }
}
