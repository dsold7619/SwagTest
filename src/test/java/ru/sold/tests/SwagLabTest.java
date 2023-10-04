package ru.sold.tests;

import org.junit.Test;
import ru.sold.pages.ProductsPage;
import ru.sold.pages.StartPage;


public class SwagLabTest extends BaseTests {

    @Test
    public void correctLogin() {
        StartPage startPage = new StartPage(driver);
        startPage.inputUserName();
        startPage.inputUserPassword();
        startPage.buttonLogin();

        new ProductsPage(driver);
    }
}

