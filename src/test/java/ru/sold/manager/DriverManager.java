package ru.sold.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sold.utils.PropsConst;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {
    private WebDriver driver;
    private final TestPropManager propManager = TestPropManager.getInstance();
    private static DriverManager instance;
    protected WebDriverWait wait;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(propManager.getProperty(PropsConst.PAGE_LOAD_TIMEOUT)), SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(propManager.getProperty(PropsConst.IMPLICITLY_WAIT)), SECONDS);
        wait = new WebDriverWait(driver, 5, 2000);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}