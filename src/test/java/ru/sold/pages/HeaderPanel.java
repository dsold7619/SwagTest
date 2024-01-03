package ru.sold.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPanel extends BaseElement {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sideBarBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;


    public SideBar clickSideBarBtn() {
        sideBarBtn.click();
        return new SideBar();
    }

    public CartPage clickCartBtn() {
        cartBtn.click();
        return new CartPage();
    }

    public int getAmountOfCartItems() {
        return Integer.parseInt(cartBadge.getText());
    }
}
