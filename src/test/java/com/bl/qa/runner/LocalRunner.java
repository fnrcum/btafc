package com.bl.qa.runner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

// Use this class to debug a test. Updating "tags" with a unique tag for your test.
@CucumberOptions(
        glue = {"com.bl.qa"},
        features = ".",
        plugin = {"json:target/cucumber-report.json", "com.bl.qa.reporting.BaseConcurentEventListener"},
        tags = {"@loginExample"}
)
public class LocalRunner extends AbstractTestNGCucumberTests {



    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}