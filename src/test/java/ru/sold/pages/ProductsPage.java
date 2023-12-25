package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sold.manager.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private final WebDriver driver;
    private final String pageUrl = "https://www.saucedemo.com/inventory.html";
    private final String productItemBaseXPath = "//div[@class='inventory_item']";
    @FindBy(xpath = "//div[(@id='inventory_container') and contains(@class,'inventory_container')]")
    private WebElement container;
    private final HeaderPanel headerPanel = new HeaderPanel();
    private final List<ProductItem> productItems = new ArrayList<>();

    public ProductsPage() {
        driver = DriverManager.getInstance().getDriver();
        checkPageInit();
        createProductItems();
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public ProductItem getFirstProductItem(){
        return productItems.get(0);
    }

    public void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & !container.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }

    private void createProductItems() {
        int count = DriverManager.getInstance().getDriver().findElements(By.xpath(productItemBaseXPath)).size();
        for (int index = 1; index <= count; index++) {
            ProductItem productItem = new ProductItem(driver, productItemBaseXPath, index);
            productItems.add(productItem);
        }
    }
}