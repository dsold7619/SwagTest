package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sold.manager.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final WebDriver driver;
    private final String pageUrl = "https://www.saucedemo.com/cart.html";

    private final String cartItemBaseXPath = "//div[@class='cart_item']";
    @FindBy(xpath = "//div[@id='cart_contents_container']")
    private WebElement cartContainer;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    private final HeaderPanel headerPanel = new HeaderPanel();

    private final List<CartItem> cartItems = new ArrayList<>();

    public CartPage() {
        driver = DriverManager.getInstance().getDriver();
        checkPageInit();
        createCarItems();
    }

    public void checkPageInit() {
        if (!pageUrl.equals(driver.getCurrentUrl()) & !cartContainer.isDisplayed()) {
            throw new AssertionError("Error loading page");
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public ProductsPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsPage();
    }

    private void createCarItems() {
        int count = DriverManager.getInstance().getDriver().findElements(By.xpath(cartItemBaseXPath)).size();
        for (int index = 1; index <= count; index++) {
            CartItem cartItem = new CartItem(driver, cartItemBaseXPath, index);
            cartItems.add(cartItem);
        }
    }
}