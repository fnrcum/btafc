package com.bl.qa.page;

import com.bl.qa.selenium.BrowserAction;
import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    protected WebDriver webDriver;

    @Inject
    protected WebDriverWait wait;

    @Inject
    protected JavascriptExecutor javascriptExecutor;

    @Inject
    protected BrowserAction browserAction;

    @Inject
    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
