package ru.sold.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sold.manager.DriverManager;

public class StartPage extends BasePage {
    private final String pageUrl = "https://www.saucedemo.com/";

    @FindBy(xpath = "//div[@class='login_container']")
    private WebElement loginContainer;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement userLogin;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement error;

    public StartPage() {

        checkPageInit();
    }

    public void checkPageInit() {
        if (!pageUrl.equals(DriverManager.getInstance().getDriver().getCurrentUrl()) & !loginContainer.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }

    public void login(String name, String password) {
        userName.click();
        userName.sendKeys(name);
        userPassword.click();
        userPassword.sendKeys(password);
        userLogin.click();
    }

    public boolean isExistError() {
        return error.isDisplayed();
    }

    public ProductsPage navigateToProductsPage() {
        login("standard_user", "secret_sauce");
        return new ProductsPage();
    }
}
