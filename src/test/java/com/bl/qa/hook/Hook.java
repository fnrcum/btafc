package com.bl.qa.hook;

import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hook {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Inject
    private WebDriver webDriver;

    /**
     * Defines the 'After Scenario' Cucumber Hook, which means it will be executed after every Scenario.
     *
     * @param scenario The scenario currently being ran.
     */
    @After
    public void afterScenario(Scenario scenario) {
        LOGGER.info("***** Executing 'After Scenario' for Scenario: " + scenario.getName() + " *****");

        if (scenario.isFailed()) {
            LOGGER.info("***** Embedding current URL into test case report for Scenario: " + scenario.getName() + " *****");
            scenario.embed(webDriver.getCurrentUrl().getBytes(), "text/plain");

            LOGGER.info("***** Embedding screenshot into test case report for Scenario: " + scenario.getName() + " *****");
            scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");

            LOGGER.info("***** Embedding inner HTML into test case report for Scenario: " + scenario.getName() + " *****");
            scenario.embed(webDriver.findElement(By.xpath("/html")).getAttribute("innerHTML").getBytes(), "text/html");
        }

        LOGGER.info("***** Quitting WebDriver for Scenario: " + scenario.getName() + " *****");
        webDriver.quit();
    }
}