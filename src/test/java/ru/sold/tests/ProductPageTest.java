package ru.sold.tests;

import org.junit.Test;
import ru.sold.pages.ProductItem;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.StartPage;

public class ProductPageTest extends BaseTests {

    @Test
    public void checkPage() {
        StartPage startPage = new StartPage(driver);
        startPage.login("secret_sauce", "standard_user");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.productItem.get(3);
    }
}