package ru.sold.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SideBar extends BaseElement {
    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    private WebElement aboutBtn;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//div[@id='root']")
    private WebElement itemBtn;

    @FindBy(xpath = "//a[@id='reset_sidebar_link']")
    private WebElement stateBtn;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    private WebElement crossBtn;

    public void clickLogoutBtn() {
        logoutBtn.click();
    }
}