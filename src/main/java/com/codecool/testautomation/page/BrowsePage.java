package com.codecool.testautomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

// Can I have a review pls?

public class BrowsePage extends BasePage {

    @FindBy (xpath = "//*[@id=\"summary-val\"]") public WebElement browseIssueHeader;
    @FindBy (xpath = "//*[@id=\"key-val\"]") public WebElement issueLink;
    @FindBy (xpath = "//div[@class='aui-page-header-main']") public WebElement mainPageHeader;
    @FindBy (xpath = "//main[@id='main']/h1[@class='projects-error-page-heading']") public WebElement pageError;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValue;
    @FindBy (xpath = "/html//span[@id='issues-subnavigation-title']") public WebElement subnavigatorTitle;

    public BrowsePage() throws MalformedURLException {}
}