package com.bl.qa.component.common.header;

import com.bl.qa.selenium.BrowserAction;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@ScenarioScoped
public class Header {

    private WebDriver webDriver;

    @Inject
    private WebDriverWait wait;

    @Inject
    private BrowserAction browserAction;

    @Inject
    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickNavigationMenuSection(String navigationMenuSectionName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[@title='%s']", navigationMenuSectionName)))).click();
    }

    public void clickNavigationMenuSectionItem(String navigationMenuSectionItemName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//li[@title='%s']", navigationMenuSectionItemName)))).click();
    }
}
