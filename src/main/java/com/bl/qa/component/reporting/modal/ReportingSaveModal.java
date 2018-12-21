package com.bl.qa.component.reporting.modal;

import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@ScenarioScoped
public class ReportingSaveModal {

    private WebDriver webDriver;

    @Inject
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(@class, 'saveReportModal') and @title='Save']")
    private WebElement saveButton;

    @Inject
    public ReportingSaveModal(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}