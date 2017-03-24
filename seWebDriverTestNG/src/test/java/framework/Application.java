package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mashomri on 24.03.2017.
 */
public class Application {
    protected WebDriver driver;
    protected WebDriverWait wait;

    DriverManager driverManager = new DriverManager();

    public void startChromeBrowser() {
        driverManager.setDriver(DriverManager.TypeOfBrowsers.CHROME);
        driver = driverManager.getDriver();
    }
}
