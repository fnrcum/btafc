package com.bl.qa.component.reporting.modal;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@ScenarioScoped
public class ReportingCopyModal {

    private WebDriver webDriver;

    @Inject
    private WebDriverWait wait;

    @FindBy(className = "reporting--copyModal-copy-button")
    private WebElement addACopyButton;

    @FindBy(id = "reporting--copyModal-reportNameInput")
    private WebElement reportNameTextField;

    @FindBy(id = "reporting--copyModal-reportScopeSelect")
    private WebElement destinationFolderList;

    @Inject
    public ReportingCopyModal(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterReportName(String reportName) {
        wait.until(ExpectedConditions.visibilityOf(reportNameTextField)).clear();
        reportNameTextField.sendKeys(reportName);
    }

    public void selectDestinationFolder(String destinationFolderName) {
        new Select(destinationFolderList).selectByVisibleText(destinationFolderName);
    }

    public void clickAddACopyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addACopyButton)).click();
    }
}
