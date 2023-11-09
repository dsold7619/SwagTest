package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.SideBar;
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

    @Test
    public void checkLogoutFromSideBar() {
        ProductsPage productsPage = navigateToProductsPage();
        SideBar sideBar = productsPage.clickSideBarBtn();
        sideBar.clickLogoutBtn();
        new StartPage(driver);
    }

    private ProductsPage navigateToProductsPage() {
        StartPage startPage = new StartPage(driver);
        startPage.login("standard_user", "secret_sauce");
        return new ProductsPage(driver);
    }
}