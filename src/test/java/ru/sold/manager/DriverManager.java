package ru.sold.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sold.utils.PropsConst;

import java.time.Duration;

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
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));
//        driver = new ChromeDriver();


//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.gecko.driver", propManager.getProperty(PropsConst.PATH_GECKO_DRIVER_WINDOWS));
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette",true);
//        WebDriver driver= new FirefoxDriver(capabilities);
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        driver = webdriver.Firefox(executable_path=r'C:\WebDrivers\geckodriver.exe', options=options);
//        driver = new FirefoxDriver(options);

        driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(propManager.getProperty(PropsConst.PAGE_LOAD_TIMEOUT)), SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(propManager.getProperty(PropsConst.IMPLICITLY_WAIT)), SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(2000));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}