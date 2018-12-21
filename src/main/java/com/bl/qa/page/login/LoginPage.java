package com.bl.qa.page.login;

import com.bl.qa.config.LoginCredentials;
import com.bl.qa.config.LoginCredentialsManager;
import com.bl.qa.config.ServerUrl;
import com.bl.qa.config.UserRole;
import com.bl.qa.page.BasePage;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ScenarioScoped
public class LoginPage extends BasePage {

    @Inject
    private ServerUrl serverUrl;

    @FindBy(id = "ctl00_ctl00_contentBody_cphMain_theme_btnSubmit")
    private WebElement loginButton;

    @FindBy(id = "ctl00_ctl00_contentBody_cphMain_theme_tbPassword")
    private WebElement passwordTextField;

    @FindBy(id = "ctl00_ctl00_contentBody_cphMain_theme_tbUserName")
    private WebElement userNameTextField;

    @Inject
    private LoginCredentialsManager loginCredentialsManager;

    @Inject
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void navigateToInstance(String instanceName) {
        switch (instanceName.toLowerCase()) {
            default:
                LOGGER.info("***** Navigating to " + serverUrl.getFcsDefaultUrl() + " *****");
                webDriver.navigate().to(serverUrl.getFcsDefaultUrl());
                break;
        }
    }

    public void login(UserRole userRole) {
        LoginCredentials loginCredentials = loginCredentialsManager.getLoginCredentials(userRole);

        LOGGER.info("***** Logging in as: " + userRole + " *****");

        login(loginCredentials.getUserName(), loginCredentials.getPassword());
    }

    private void login(String username, String password) {
        browserAction.waitForAngularRequestFinish();
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}