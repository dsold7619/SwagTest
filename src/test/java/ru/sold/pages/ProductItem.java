package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductItem extends Container {
    private final WebElement title;

    public ProductItem(WebDriver driver, String containerBase) {
        this(driver, containerBase, 1);
    }

    private ProductItem(WebDriver driver, String baseXPath, int index) {
        super(driver, baseXPath, index);
        this.title = get(getCurrentXPath() + "//button");
    }

    public ProductItem get(int index) {
        return new ProductItem(getDriver(), getBaseXPath(), index);
    }

    private WebElement get(String Xpath) {
        return getDriver().findElement(By.xpath(Xpath));
    }
}