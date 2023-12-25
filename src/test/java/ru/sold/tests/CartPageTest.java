package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.*;

import java.util.List;

public class CartPageTest extends BaseTests {

    @Test
    public void checkCartPageInit() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getHeaderPanel().clickCartBtn();
        new CartPage();
    }

    @Test
    public void checkCartItemOnCartPage() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();

        List<String> productItemTitles = productsPage.getProductItems().stream()
                .limit(3)
                .peek(ProductItem::clickAddToCartButton)
                .map(ProductItem::getTitle)
                .toList();

        CartPage cartPage = productsPage.getHeaderPanel().clickCartBtn();
        List<String> cartItemTitles = cartPage.getCartItems().stream()
                .map(CartItem::getTitle)
                .toList();

        Assert.assertEquals("Selected product doesn't match product in cart", productItemTitles, cartItemTitles);
    }
}