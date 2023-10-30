package ru.sold.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sold.manager.TestPropManager;
import ru.sold.utils.PropsConst;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ru.sold.utils.PropsConst.BASE_URL;

public class BaseTests {
    protected WebDriver driver;
    private final TestPropManager propManager = TestPropManager.getInstance();
    protected WebDriverWait wait;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(propManager.getProperty(PropsConst.PAGE_LOAD_TIMEOUT)), SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(propManager.getProperty(PropsConst.IMPLICITLY_WAIT)), SECONDS);
        wait = new WebDriverWait(driver, 5, 2000);
        driver.navigate().to(propManager.getProperty(BASE_URL));
    }

    @After
    public void after() {
        driver.quit();
    }
}
