package com.bl.qa.component.reporting.atlas;

import com.bl.qa.component.common.atlas.AtlasSideBar;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ScenarioScoped
public class ReportingAtlasSideBar extends AtlasSideBar {

    @FindBy(xpath = "//button[@id='modules--reportEdit-sidebar-actions-save']")
    private WebElement saveReportButton;

    @Inject
    public ReportingAtlasSideBar(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSaveReport() {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(saveReportButton)).click();
    }
}
