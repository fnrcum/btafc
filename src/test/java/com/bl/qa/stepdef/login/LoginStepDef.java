package com.bl.qa.stepdef.login;

import com.bl.qa.config.UserRole;
import com.bl.qa.page.login.LoginPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class LoginStepDef {

    @Inject
    private LoginPage loginPage;

    @Given("^~Login~ I log in as a \"([^\"]*)\"$")
    public void iLoginAs(UserRole userRole) {
        loginPage.login(userRole);
    }
}