package ru.sold.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        Assertions.assertTrue(new StartPage().isExistError(), "Page didn't load");
    }
}

