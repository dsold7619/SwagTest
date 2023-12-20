package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductItem extends Container {
    private final WebElement title;
    private final WebElement picture;
    private final WebElement button;

    public ProductItem(WebDriver driver, String baseXPath, int index) {
        super(driver, baseXPath, index);
        this.title = get(getCurrentXPath() + "//div[@class='inventory_item_name ']");
        this.picture = get(getCurrentXPath() + "//div[@class='inventory_item_img']");
        this.button = get(getCurrentXPath() + "//button");
    }

    public boolean isPictureDisplayed() {
        return picture.isDisplayed();
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickAddToCartButton() {
        if (button.getText().contains("Add to cart")) {
            button.click();
        } else {
            throw new RuntimeException("This button hasn't label 'Add to cart'");
        }
    }

    public void clickRemoveButton() {
        if (button.getText().contains("Remove")) {
            button.click();
        } else {
            throw new RuntimeException("This button hasn't label 'Remove'");
        }
    }


    private WebElement get(String Xpath) {
        return getDriver().findElement(By.xpath(Xpath));
    }
}