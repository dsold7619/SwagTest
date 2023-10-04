package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    private final String pageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[(@id='inventory_container') and contains(@class,'inventory_container')]")
    WebElement container;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & container.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }
}