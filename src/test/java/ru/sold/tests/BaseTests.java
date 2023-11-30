package ru.sold.tests;

import org.junit.After;
import org.junit.Before;
import ru.sold.manager.DriverManager;
import ru.sold.manager.TestPropManager;

import static ru.sold.utils.PropsConst.BASE_URL;

public class BaseTests {
    private final TestPropManager propManager = TestPropManager.getInstance();

    @Before
    public void before() {
        DriverManager.getInstance().getDriver().navigate().to(propManager.getProperty(BASE_URL));
    }

    @After
    public void after() {
        DriverManager.getInstance().quitDriver();
    }
}
