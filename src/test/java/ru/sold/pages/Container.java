package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Container {
    private final WebDriver driver;
    private final String currentXPath;

    public Container(WebDriver driver, String baseXPath, int index) {
        this.driver = driver;
        this.currentXPath = baseXPath + "[" + index + "]";
        checkInit();
    }

    private void checkInit() {
        if (!driver.findElement(By.xpath(currentXPath)).isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentXPath() {
        return currentXPath;
    }
}