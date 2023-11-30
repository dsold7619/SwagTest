package ru.sold.pages;

import org.openqa.selenium.support.PageFactory;
import ru.sold.manager.DriverManager;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }

    public abstract void checkPageInit();
}
