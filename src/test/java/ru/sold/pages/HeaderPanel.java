package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPanel {
    private final WebDriver driver;
    private final WebElement sideBarBtn;
    private final WebElement cartBtn;

    public HeaderPanel(WebDriver driver) {
        this.driver = driver;
        this.sideBarBtn = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        this.cartBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public void clickSideBarBtn() {
        sideBarBtn.click();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }
}
