package com.bl.qa.stepdef.home;

import com.bl.qa.page.home.HomePage;
import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScoped
public class HomeStepDef {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Inject
    private HomePage homePage;

    @Then("^~Home~ I verify the home page title is displayed successfully$")
    public void homeIVerifyTheHomePageTitleIsDisplayedSuccessfully() {
        assertThat(homePage.isTitleDisplayed()).isTrue();
    }

    @And("^~Home~ I navigate to \"([^\"]*)\" then \"([^\"]*)\"$")
    public void productsHeaderINavigateTo(String navigationMenuSectionName, String navigationMenuSectionItemName) {
        homePage.clickNavigationMenuSection(navigationMenuSectionName);
        homePage.clickNavigationMenuSectionItem(navigationMenuSectionItemName);
    }
}