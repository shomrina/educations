package framework;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;

/**
 * Created by Marina on 26.02.2017.
 */
public class DriverManager {

    private WebDriver driver;
    private WebDriverWait wait;
    public Logger LOG = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    public WebDriver getDriver() {
        return driver;
    }

    //задание типов браузеров для тестирования
    public enum TypeOfBrowsers {
        CHROME,
        FIREFOX,
        IE,
        EDGE,
        FIREFOX_ESR,
        FIREFOX_NIGHTLY,
        FIREFOX_DEVELOPER_EDITION
    }

    public WebDriver setDriver(TypeOfBrowsers typeOfBrowsers) {
        if (driver == null) {
            switch (typeOfBrowsers) {
                case CHROME:
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<CHROME Driver is created>");
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<FIREFOX Driver is created>");
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<IE Driver is created>");
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<EDGE Driver is created>");
                    break;
                case FIREFOX_ESR:
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(FirefoxDriver.MARIONETTE, false);
                    driver = new FirefoxDriver(
                            new FirefoxBinary(new File("E:\\Program Files\\Mozilla Firefox ESR\\firefox.exe")),  //FirefoxBinary - указывает путь к исполняемому файлу бразуера
                            new FirefoxProfile(), caps);                                                                   //FirefoxProfile  - отвечает за настройки создаваемого профиля браузера. В данном случае профиль по умолчанию.
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                       //чтобы селениум дожидался, когда элемент появится на странице
                    System.out.println(((HasCapabilities) driver).getCapabilities());                                      //вывод капабилитес в консоль
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<FIREFOX_ESR Driver is created>");
                    break;
                case FIREFOX_NIGHTLY:
                    DesiredCapabilities caps2 = new DesiredCapabilities();
                    caps2.setCapability(FirefoxDriver.MARIONETTE, true);                                             //launch browser by new scheme
                    driver = new FirefoxDriver(
                            new FirefoxBinary(new File("E:\\Program Files (x86)\\Nightly\\firefox.exe")),        //FirefoxBinary - указывает путь к исполняемому файлу бразуера
                            new FirefoxProfile(), caps2);                                                                   //FirefoxProfile  - отвечает за настройки создаваемого профиля браузера. В данном случае профиль по умолчанию.
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                       //чтобы селениум дожидался, когда элемент появится на странице
                    System.out.println(((HasCapabilities) driver).getCapabilities());                                      //вывод капабилитес в консоль
                    wait = new WebDriverWait(driver, 10);
                    LOG.info("<FIREFOX_NIGHTLY Driver is created>");
                    break;
                case FIREFOX_DEVELOPER_EDITION:
                    DesiredCapabilities caps3 = new DesiredCapabilities();
                    caps3.setCapability(FirefoxDriver.MARIONETTE, true);                                             //launch browser by new scheme
                    driver = new FirefoxDriver(
                            new FirefoxBinary(new File("E:\\Program Files (x86)\\Firefox Developer Edition\\firefox.exe")),        //FirefoxBinary - указывает путь к исполняемому файлу бразуера
                            new FirefoxProfile(), caps3);                                                                   //FirefoxProfile  - отвечает за настройки создаваемого профиля браузера. В данном случае профиль по умолчанию.
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                       //чтобы селениум дожидался, когда элемент появится на странице
                    System.out.println(((HasCapabilities) driver).getCapabilities());                                      //вывод капабилитес в консоль
                    wait = new WebDriverWait(driver, 10);
            }
//            driver.manage().window().maximize();
        }
        return driver;
    }


    //метод для инициализации драйвера
    public WebDriver setDriverString(String browser) {
        return setDriver(TypeOfBrowsers.valueOf(browser));
    }
}
