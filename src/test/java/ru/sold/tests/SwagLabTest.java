package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.StartPage;


public class SwagLabTest extends BaseTests {

    @Test
    public void correctLogin() {
        StartPage startPage = new StartPage(driver);
        startPage.login("secret_sauce", "standard_user");
        new ProductsPage(driver);
    }

    @Test
    public void invalidLogin() {
        StartPage startPage = new StartPage(driver);
        startPage.login("123", "standard_user");
        Assert.assertTrue(startPage.isExistError());
    }
}

