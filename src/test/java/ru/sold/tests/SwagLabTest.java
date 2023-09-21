package ru.sold.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SwagLabTest extends BaseTests {

    @Test
    public void test() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.click();
        userName.sendKeys("standard_user");

        WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
        userPassword.click();
        userPassword.sendKeys("secret_sauce");

        WebElement userLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        userLogin.click();
        String url = driver.getCurrentUrl();
        String errorMessage = "Страничка не загрузилась";
        Assert.assertEquals(errorMessage, "https://www.saucedemo.com/inventory.html", url);
    }
}

