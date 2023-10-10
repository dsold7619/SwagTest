package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private final String pageUrl = "https://www.saucedemo.com/inventory.html";
    @FindBy(xpath = "//div[(@id='inventory_container') and contains(@class,'inventory_container')]")
    private WebElement container;
    private final String productItemBaseXPath = "//div[@class='inventory_item']";
    public final ProductItem productItem = new ProductItem(driver, productItemBaseXPath);
    public List<ProductItem> productItems = new ArrayList<>();

    public ProductsPage(WebDriver driver) {
        super(driver);
        checkPageInit();
    }

    public void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & !container.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }
}