package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPanel extends BaseElement {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sideBarBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    public HeaderPanel(WebDriver driver) {
        super(driver);
    }

    public SideBar clickSideBarBtn() {
        sideBarBtn.click();
        return new SideBar(driver);
    }

    public void clickCartBtn() {
        cartBtn.click();
    }
}
