package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.*;

import java.util.List;

public class ProductPageTest extends BaseTests {

    @Test
    public void checkPictureForProductItems() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().forEach(item -> Assert.assertTrue(item.isPictureDisplayed()));
    }

    @Test
    public void checkTitleForProductItem() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        String actualTitle = productsPage.getFirstProductItem().getTitle();
        Assert.assertEquals("Product name in the cart doesn't match selected", "Sauce Labs Backpack", actualTitle);
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
        productsPage.getFirstProductItem().clickAddToCartButton();

        CartPage cartPage = productsPage.getHeaderPanel().clickCartBtn();
        Assert.assertEquals(1, cartPage.getCartItems().size());
        productsPage = cartPage.clickContinueShoppingButton();
        String textAfter = productsPage.getFirstProductItem().getButtonText();
        Assert.assertEquals("Button name did not change after adding the product to the cart", "Remove", textAfter);
    }

    @Test
    public void checkProductItemButtonRemove() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().stream()
                .limit(3)
                .forEach(ProductItem::clickAddToCartButton);

        CartPage cartPage = productsPage.getHeaderPanel().clickCartBtn();

        productsPage = cartPage.clickContinueShoppingButton();
        List<ProductItem> productItems = new java.util.ArrayList<>(productsPage.getProductItems().stream()
                .filter(productItem -> productItem.getButtonText().equals("Remove"))
                .toList());
        productItems.get(0).clickRemoveButton();
        productItems.remove(0);
        List<String> productItemTitles = productItems.stream()
                .map(ProductItem::getTitle)
                .toList();

        cartPage = productsPage.getHeaderPanel().clickCartBtn();
        List<String> cartItemTitles = cartPage.getCartItems().stream()
                .map(CartItem::getTitle)
                .toList();

        Assert.assertEquals("Nomenclature from the ProductsPage corresponds with the CartPage", productItemTitles, cartItemTitles);
    }

    @Test
    public void checkCartBadge() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().stream()
                .limit(3)
                .forEach(ProductItem::clickAddToCartButton);
        Assert.assertEquals(3, productsPage.getHeaderPanel().getAmountOfCartItems());
    }

    @Test
    public void checkCartBadgeDecrease() {
        ProductsPage productsPage = new StartPage().navigateToProductsPage();
        productsPage.getProductItems().stream()
                .limit(3)
                .forEach(ProductItem::clickAddToCartButton);

        // The DOM was changed through the action
        // https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document
        new ProductsPage().getFirstProductItem().clickRemoveButton();
        Assert.assertEquals(2, productsPage.getHeaderPanel().getAmountOfCartItems());
    }
}
