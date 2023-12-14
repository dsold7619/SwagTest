package ru.sold.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sold.manager.DriverManager;

public class CartPage extends BasePage {
    private final WebDriver driver;
    private final String pageUrl = "https://www.saucedemo.com/cart.html";
    @FindBy(xpath = "//div[@id='cart_contents_container']")
    private WebElement cartContainer;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    private final HeaderPanel headerPanel = new HeaderPanel();

    public CartPage() {
        driver = DriverManager.getInstance().getDriver();
        checkPageInit();
    }

    public void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & !cartContainer.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }
}