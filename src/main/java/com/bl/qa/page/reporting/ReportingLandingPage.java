package com.bl.qa.page.reporting;

import com.bl.qa.component.reporting.modal.ReportingCopyModal;
import com.bl.qa.page.BasePage;
import com.bl.qa.page.LocalVariable;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ScenarioScoped
public class ReportingLandingPage extends BasePage {

    private static final String REPORT_NAME = "Report Name";

    @Inject
    private ReportingCopyModal reportingCopyModal;

    @FindBy(xpath = "//input[@name='title']")
    private WebElement reportNameTextField;

    @Inject
    public ReportingLandingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void copyReport(String reportName, String destination) {
        searchForReport(reportName);

        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[text()='%s']/parent::*//span[contains(@class,'copy')]",
                        reportName)))).click();

        LocalVariable.put(REPORT_NAME, reportName + " - " + RandomStringUtils.randomAlphanumeric(10));

        reportingCopyModal.enterReportName(LocalVariable.get(REPORT_NAME));
        reportingCopyModal.selectDestinationFolder(destination);
        reportingCopyModal.clickAddACopyButton();
    }

    public void clickTab(String reportingTabName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[@data-tab-name='%s']",
                reportingTabName.replaceAll(" ", ""))))).click();
    }

    public void editCopiedReport() {
        searchForReport(LocalVariable.get(REPORT_NAME));

        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                (String.format("//div[text()='%s']/parent::*//span[contains(@class,'edit')]",
                        LocalVariable.get(REPORT_NAME))))).click();
    }

    public void searchForReport(String reportName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.visibilityOf(reportNameTextField)).clear();
        reportNameTextField.sendKeys(reportName);
    }
}