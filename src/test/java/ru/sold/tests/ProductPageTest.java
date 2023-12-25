package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.CartPage;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.SideBar;
import ru.sold.pages.StartPage;

public class ProductPageTest extends BaseTests {

    @Test
    public void checkPictureForProductItems() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().forEach(item -> Assert.assertTrue(item.isPictureDisplayed()));
    }

    @Test
    public void checkTitleForProductItem() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        String actualTitle = productsPage.getProductItems().get(0).getTitle();
        Assert.assertEquals("Product name in the cart doesn't match selected","Sauce Labs Backpack", actualTitle);
    }

    @Test
    public void checkLogoutFromSideBar() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        SideBar sideBar = productsPage.getHeaderPanel().clickSideBarBtn();
        sideBar.clickLogoutBtn();
        new StartPage();
    }

    @Test
    public void checkProductItemButtonText() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().get(0).clickAddToCartButton();

        CartPage cartPage = productsPage.getHeaderPanel().clickCartBtn();
        Assert.assertEquals(1, cartPage.getCartItems().size());
        productsPage = cartPage.clickContinueShoppingButton();
        String textAfter = productsPage.getProductItems().get(0).getButtonText();
        Assert.assertEquals("Button name did not change after adding the product to the cart","Remove", textAfter);
    }
}
