package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.StartPage;

public class ProductPageTest extends BaseTests {

    @Test
    public void checkPictureForProductItems() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.getProductItems().forEach(item -> Assert.assertTrue(item.isPictureDisplayed()));
    }

    @Test
    public void checkTitleForProductItem() {
        ProductsPage productsPage = navigateToProductsPage();
        String actualTitle = productsPage.getProductItems().get(0).getTitle();
        Assert.assertEquals("Sauce Labs Backpack", actualTitle);
    }

    private ProductsPage navigateToProductsPage() {
        StartPage startPage = new StartPage(driver);
        startPage.login("secret_sauce", "standard_user");
        return new ProductsPage(driver);
    }
}