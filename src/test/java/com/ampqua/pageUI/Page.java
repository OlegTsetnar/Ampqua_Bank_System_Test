package com.ampqua.pageUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getPageHeader(By locator);

    public abstract String getPageTitle();

    public abstract WebElement findElement(By locator);

    public abstract List<WebElement> findElements(By locator);

    public abstract void waitForElementPresent(By locator);

    public abstract void refreshPage();

    public abstract String getCurrentUrl();

}
