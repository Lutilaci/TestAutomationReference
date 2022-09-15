package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreatePage extends BasePage{

    @FindBy (xpath = "//*[@id=\"opsbar-operations_more\"]") public WebElement actionButton;
    @FindBy (xpath = "//button[text()='Cancel']") public WebElement cancelButton;
    @FindBy (xpath = "//div[@id='qf-field-summary']//div[@role='alert']") public WebElement createIssueErrorMessage;
    @FindBy (xpath = "//*[@id=\"create-issue-submit\"]") public WebElement createIssueButton;
    @FindBy (xpath = "//*[@id=\"create-issue-dialog\"]") public WebElement createIssueDialog;
    @FindBy (xpath = "//aui-item-link[@id='create-subtask']/a/span") public WebElement createSubClass;
    @FindBy (xpath = "//*[@id=\"delete-issue\"]/a") public WebElement deleteButton;
    @FindBy (xpath = "//a[text()='Delete']") public WebElement deleteSubTaskButton;
    @FindBy (xpath = "/html//input[@id='delete-issue-submit']") public WebElement finalDeleteButton;
    @FindBy (css = "tr:nth-of-type(1) > .issue_actions > a[title='Actions (Type . to access issue actions)'] > .aui-icon.aui-icon-small.aui-iconfont-more") public WebElement hiddenSubTaskButton;
    @FindBy (xpath="//*[@id=\"summary-val\"]") public WebElement issueHeader;
    @FindBy (xpath = "//*[@id=\"find_link\"]") public WebElement issuesButton;
    @FindBy (xpath = "//ul[@class='aui-last']") public WebElement issueScrollDown;
    @FindBy (id ="issuetype-field") public WebElement issueTypeSelector;
    @FindBy(linkText = "Create") public WebElement  mainCreateButton;
    @FindBy (xpath = "//a[@id='opsbar-operations_more']") public WebElement moreButton;
    @FindBy (xpath = "//*[@id=\"aui-flag-container\"]/div/div") public WebElement popupMessage;
    @FindBy (xpath = "//input[@id='project-field']") public WebElement projectField;
    @FindBy (css = ".no-results > h2") public WebElement resultPageContent;
    @FindBy (xpath = "(//button[@type='button'])[3]") public WebElement searchButton;
    @FindBy (xpath = "/html//li[@id='issues_new_search_link']") public WebElement searchForIssuesButton;
    @FindBy (xpath = "//*[@id=\"searcher-query\"]") public WebElement searchForIssueField;
    @FindBy (css = ".stsummary > a") public WebElement subTaskTableFirstRow;
    @FindBy (xpath = "//*[@id=\"issuerow12961\"]/td[2]/a") public WebElement subTaskName;
    @FindBy (xpath= "//*[@id=\"summary\"]") public WebElement summaryField;

    public List<String> issueTypesSupposedToBe = Arrays.asList("Bug", "Story", "Task");

    public CreatePage()throws MalformedURLException {}

    public void restoreIssue(){
        waitForElementToClick(actionButton);
        clickButton(deleteButton);
        waitForElementToClick(finalDeleteButton);
    }

    public void restoreSubTask(){
        clickButton(hiddenSubTaskButton);
        waitForElementToClick(deleteSubTaskButton);
        waitForElementToClick(finalDeleteButton);
    }

    public void createSubTask(){
        clickButton(moreButton);
        clickButton(createSubClass);
        waitForElementToSendText(summaryField, "Sub-task test");
        clickButton(createIssueButton);
    }

    public void clearIssueType(){
        String os = System.getProperty("os.name");
        wait.until(ExpectedConditions.elementToBeClickable(issueTypeSelector));
        if (os.equals("Mac OS X")){
            waitForElementToSendText(issueTypeSelector, Keys.COMMAND + "a");
        }else{
            waitForElementToSendText(issueTypeSelector, Keys.CONTROL + "a");
        }
        issueTypeSelector.sendKeys(Keys.DELETE);
    }

    public void clearProjectField(){
        String os = System.getProperty("os.name");
        if (os.equals("Mac OS X")){
            waitForElementToSendText(projectField, Keys.COMMAND + "a");
        }else{
            waitForElementToSendText(projectField, Keys.CONTROL + "a");
        }
        projectField.sendKeys(Keys.DELETE);
    }

    public void createSpecificIssue(String projectName, String issueType, String summary){
        waitForElementToClick(mainCreateButton);
        waitForWebElementToBePresent(createIssueDialog);
        fillOutCreation(projectName, issueType, summary);
        waitForElementToClick(createIssueButton);
        waitForWebElementToBePresent(popupMessage);
        waitForElementToClick(driver.findElement(By.partialLinkText("Happy Test")));
    }

    public void createIssueWithEmptySummary(){
        clickButton(mainCreateButton);
        waitForElementToClick(createIssueButton);
        waitForWebElementToBePresent(createIssueErrorMessage);
    }

    public List<String> getIssueTypes(){
        waitForElementToClick(issueTypeSelector);

        List<String> issueTypes = new ArrayList<>();
        issueTypes.add(issueTypeSelector.getAttribute("value"));

        WebElement ul_Element = issueScrollDown;
        List<WebElement> li_All = ul_Element.findElements(By.tagName("li"));


        for (WebElement webElement : li_All) {
            issueTypes.add(webElement.getText());
        }

        clickButton(cancelButton);
        Collections.sort(issueTypes);
        return issueTypes;
    }

    public void setProjectTo(String project){
        clearProjectField();
        projectField.sendKeys(project);
        projectField.sendKeys(Keys.RETURN);
    }

    public void setIssueTo(String issueType){
        clearIssueType();
        issueTypeSelector.sendKeys(issueType);
        wait.until(ExpectedConditions.elementToBeClickable(
                issueTypeSelector)).sendKeys(Keys.RETURN);
    }

    public void setSummaryTo(String summary){
        waitForElementToSendText(summaryField, summary);
    }

    public void cancelCreation(){
        clickButton(cancelButton);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void fillOutCreation(String projectName, String issueType, String summary){
        setProjectTo(projectName);
        setIssueTo(issueType);
        setSummaryTo(summary);
    }

    public void validateIssueDoesntExist(String issueName){
        searchForIssue(issueName);
        waitForWebElementToBePresent(resultPageContent);
    }

    public void searchForIssue(String issueName){
        waitForElementToClick(issuesButton);
        waitForElementToClick(searchForIssuesButton);
        waitForElementToSendText(searchForIssueField, issueName);
        clickButton(searchButton);
    }

    public void clickCreateButton(){
        openUrl("secure/Dashboard.jspa");
        clickButton(mainCreateButton);
    }
}
