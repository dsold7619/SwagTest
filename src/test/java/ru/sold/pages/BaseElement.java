package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseElement {
    protected final WebDriver driver;

    public BaseElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
      }
}