package com.bl.qa.page.home;

import com.bl.qa.component.common.header.Header;
import com.bl.qa.page.BasePage;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
public class HomePage extends BasePage {

    @Inject
    private Header header;

    @FindBy(className = "bl--navigation-page-title")
    private WebElement title;

    @Inject
    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public void clickNavigationMenuSection(String navigationMenuSectionName) {
        header.clickNavigationMenuSection(navigationMenuSectionName);
    }

    public void clickNavigationMenuSectionItem(String navigationMenuSectionItemName) {
        header.clickNavigationMenuSectionItem(navigationMenuSectionItemName);
    }
}