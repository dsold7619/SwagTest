package ru.sold.pages;

import org.openqa.selenium.support.PageFactory;
import ru.sold.manager.DriverManager;

public abstract class BaseElement {

    public BaseElement() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }
}