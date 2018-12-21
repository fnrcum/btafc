package com.bl.qa.stepdef.navigation;

import com.bl.qa.page.login.LoginPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ScenarioScoped
public class NavigationStepDef {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Inject
    private LoginPage loginPage;

    @Given("^~Navigate~ I navigate to the \"([^\"]*)\" instance$")
    public void iNavigateToTheInstance(String instanceName) {
        loginPage.navigateToInstance(instanceName);
    }
}