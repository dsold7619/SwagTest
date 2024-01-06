package ru.sold.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.sold.manager.DriverManager;
import ru.sold.manager.TestPropManager;

import static ru.sold.utils.PropsConst.BASE_URL;

public class BaseTests {
    private final TestPropManager propManager = TestPropManager.getInstance();

    @BeforeEach
    public void before() {
        DriverManager.getInstance().getDriver().navigate().to(propManager.getProperty(BASE_URL));
    }

    @AfterEach
    public void after() {
        DriverManager.getInstance().quitDriver();
    }
}
