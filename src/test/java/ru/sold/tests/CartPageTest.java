package ru.sold.tests;

import org.junit.Test;
import ru.sold.pages.CartPage;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.StartPage;

public class CartPageTest extends BaseTests {

    @Test
    public void checkCartPageInit() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getHeaderPanel().clickCartBtn();
        new CartPage();
    }
}