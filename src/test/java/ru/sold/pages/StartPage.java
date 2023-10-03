package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    private final WebDriver driver;
    private final String pageUrl = "https://www.saucedemo.com/";

    @FindBy(xpath = "//div[@class='login_container']")
    private WebElement loginContainer;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement userLogin;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        checkPageInit();
    }

    public void inputUserName() {
        userName.click();
        userName.sendKeys("standard_user");
    }

    public void inputUserPassword() {
        userPassword.click();
        userPassword.sendKeys("secret_sauce");
    }

    public void buttonLogin() {
        userLogin.click();
    }

    private void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & loginContainer.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }
}
