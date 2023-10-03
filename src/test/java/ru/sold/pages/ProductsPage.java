package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private final WebDriver driver;
    private final String pageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[(@id='inventory_container') and contains(@class,'inventory_container')]")
    WebElement container;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        checkPageInit();
    }

    private void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & container.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }
}