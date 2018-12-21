package com.bl.qa.stepdef.reporting;

import com.bl.qa.component.common.atlas.AtlasSideBarFieldSection;
import com.bl.qa.page.reporting.ReportingEditPage;
import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScoped
public class ReportingEditStepDef {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Inject
    private ReportingEditPage reportingEditPage;

    @And("^~ReportingEdit~ I add the field \"([^\"]*)\" to the \"([^\"]*)\" section$")
    public void reportingEditIAddTheFieldToTheSection(String fieldName, AtlasSideBarFieldSection atlasSideBarFieldSection) {
        reportingEditPage.addField(fieldName, atlasSideBarFieldSection);
    }

    @When("^~ReportingEdit~ I save the report$")
    public void reportingEditISaveTheReport() {
        reportingEditPage.saveReport();
    }

    @Then("^~ReportingEdit~ I verify the field \"([^\"]*)\" is added to the \"([^\"]*)\" section$")
    public void reportingEditIVerifyTheFieldIsAddedToTheSection(String fieldName, AtlasSideBarFieldSection atlasSideBarFieldSection) {
        assertThat(reportingEditPage.isFieldAdded(fieldName, atlasSideBarFieldSection)).isTrue();
    }
}