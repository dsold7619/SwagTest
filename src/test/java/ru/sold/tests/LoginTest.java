package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sold.pages.StartPage;

public class LoginTest extends BaseTests {

    @Test
    public void correctLogin() {
        new StartPage().navigateToProductsPage();
    }

    @Test
    public void invalidLogin() {
        StartPage startPage = new StartPage();
        startPage.login("123", "standard_user");
        Assert.assertTrue(new StartPage().isExistError());
    }
}

