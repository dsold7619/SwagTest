package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItem extends Container {
    private final WebElement title;
    private final WebElement button;

    public CartItem(WebDriver driver, String baseXPath, int index) {
        super(driver, baseXPath, index);
        this.title = get(getCurrentXPath() + "//div[@class='inventory_item_name']");
        this.button = get(getCurrentXPath() + "//button[contains(text(),'Remove')]");
    }

    public String getTitle() {
        return title.getText();
    }

    private WebElement get(String Xpath) {
        return getDriver().findElement(By.xpath(Xpath));
    }
}
