package com.bl.qa.page.reporting;

import com.bl.qa.component.common.atlas.AtlasSideBarFieldSection;
import com.bl.qa.component.reporting.atlas.ReportingAtlasSideBar;
import com.bl.qa.component.reporting.modal.ReportingSaveModal;
import com.bl.qa.page.BasePage;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class ReportingEditPage extends BasePage {

    @Inject
    private ReportingAtlasSideBar reportingAtlasSideBar;

    @Inject
    private ReportingSaveModal reportingSaveModal;

    @Inject
    public ReportingEditPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void addField(String fieldName, AtlasSideBarFieldSection atlasSideBarFieldSection) {
        reportingAtlasSideBar.clickAddIconOnField(atlasSideBarFieldSection);
        reportingAtlasSideBar.searchForField(fieldName);
        reportingAtlasSideBar.selectField(fieldName);
        reportingAtlasSideBar.clickApplyButton();
    }

    public void saveReport() {
        reportingAtlasSideBar.clickSaveReport();
        reportingSaveModal.clickSaveButton();
    }

    public boolean isFieldAdded(String fieldName, AtlasSideBarFieldSection atlasSideBarFieldSection) {
        return reportingAtlasSideBar.getListOfFieldsAddedToSection(atlasSideBarFieldSection).contains(fieldName);
    }
}