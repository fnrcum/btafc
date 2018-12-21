package com.bl.qa.component.common.atlas;

import com.bl.qa.selenium.BrowserAction;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

@ScenarioScoped
public class AtlasSideBar {

    private WebDriver webDriver;

    @Inject
    protected BrowserAction browserAction;

    @Inject
    protected WebDriverWait wait;

    @FindBy(xpath = "//input[contains(@class,'atlas--ui-fieldSelector-sidebar-stage-addFields-search')]")
    private WebElement fieldSearchTextField;

    @FindBy(xpath = "//button[contains(@class,'atlas--ui-fieldSelector-sidebar-stage-fields-btnApply')]")
    private WebElement applyButton;

    @Inject
    public AtlasSideBar(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddIconOnField(AtlasSideBarFieldSection atlasSideBarFieldSection) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[text()='%s']/button",
                atlasSideBarFieldSection.toString())))).click();
    }

    public void clickApplyButton() {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    public List<String> getListOfFieldsAddedToSection(AtlasSideBarFieldSection atlasSideBarFieldSection) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'atlas--ui-sortableListSelector')]")));
        List<WebElement> fieldsElements =
                webDriver.findElements(By.xpath(String.format("//div[text()='%s']/following-sibling::ul" +
                        "//*[contains(@class,'atlas--ui-sortableListSelector-item-text')]",
                        atlasSideBarFieldSection.toString())));

        return fieldsElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void searchForField(String fieldName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='atlas--ui-fieldSelector-add-remove']")));
        wait.until(ExpectedConditions.visibilityOf(fieldSearchTextField)).clear();
        fieldSearchTextField.sendKeys(fieldName);
    }

    public void selectField(String fieldName) {
        browserAction.waitForPageLoad();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//label[contains(@for," +
                "'atlas--ui-fieldSelector') and text()='%s']", fieldName)))).click();
    }
}