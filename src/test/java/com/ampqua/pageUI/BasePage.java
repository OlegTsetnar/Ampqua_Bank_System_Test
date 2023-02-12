package com.ampqua.pageUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {


    public BasePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Page Header
     */
    @Override
    public String getPageHeader(By locator) {
        return findElement(locator).getText();
    }

    /**
     * Get Page Title
     */
    @Override
    public String getPageTitle() {
        return super.driver.getTitle();
    }

    /**
     * Get WebElement
     */
    @Override
    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Error occurred while creating element" + locator.toString());
            return null;
        }
    }

    /**
     * Get List of WebElements
     */
    @Override
    public List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            System.out.println("Error occurred while creating element" + locator.toString());
            return null;
        }
    }

    /**
     * Wait until element present
     */
    @Override
    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e + locator.toString());
        }
    }

    /**
     * Refresh Page
     */
    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Get Current URL
     */
    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Extract integer values from String
     */
    public int extractIntegerFromString(String str) {
        int value = 0;
        String intValue = str.replaceAll("[^0-9]", "");
        value = Integer.parseInt(intValue);
        return value;
    }

    /**
     * Waits until the element is ready
     *
     * @param element to be evaluated
     */
    public void waitForElementReady(WebElement element) {
        if (wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementSelectionStateToBe(element, false)))) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    /**
     * Waits until the element is clickable
     *
     * @param element to be evaluated
     */
    public void waitForElementToBeClickable(WebElement element) {
        if (wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementSelectionStateToBe(element, false)))) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }
}