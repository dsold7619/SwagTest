package ru.sold.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SideBar {
    private final WebDriver driver;

    private final WebElement aboutBtn;
    private final WebElement logoutBtn;
    private final WebElement itemBtn;
    private final WebElement stateBtn;
    private final WebElement crossBtn;

    public SideBar(WebDriver driver) {
        this.driver = driver;
        this.aboutBtn = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
        this.logoutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        this.itemBtn = driver.findElement(By.xpath("//div[@id='root']"));
        this.stateBtn = driver.findElement(By.xpath("//a[@id='reset_sidebar_link']"));
        this.crossBtn = driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']"));
    }

    public void clickLogoutBtn(){
        logoutBtn.click();
    }
}