package com.bl.qa.stepdef.reporting;

import com.bl.qa.page.reporting.ReportingLandingPage;
import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ScenarioScoped
public class ReportingStepDef {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Inject
    private ReportingLandingPage reportingLandingPage;

    @And("^~Reporting~ I select the \"([^\"]*)\" tab$")
    public void reportingISelectTheTab(String reportingTabName) {
        reportingLandingPage.clickTab(reportingTabName);
    }

    @And("^~Reporting~ I copy the report \"([^\"]*)\" to \"([^\"]*)\"$")
    public void reportingICopyTheReportTo(String reportName, String destination) {
        reportingLandingPage.copyReport(reportName, destination);
    }

    @And("^~Reporting~ I select Edit on the report I copied$")
    public void reportingISelectEditOnTheReportICopied() {
        reportingLandingPage.editCopiedReport();
    }
}