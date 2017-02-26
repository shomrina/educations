package myTests.launchBrowsers;



import framework.DriverManager;
import framework.pages.LoginAdminPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppChromeTest {
    private WebDriver driver;
    private WebDriverWait wait;
    DriverManager driverManager = new DriverManager();

    @BeforeMethod()
    public void start() {

        driverManager.setDriver(DriverManager.TypeOfBrowsers.CHROME);
        driver = driverManager.getDriver();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstBrowserTest() {
        LoginAdminPage loginAdminPage = new LoginAdminPage(driver);
        loginAdminPage.fillLoginAdmin();
        loginAdminPage.clickLoginButtonAdmin();
    }

    @AfterMethod
    public void stop() {
        driver.quit();
        driver = null;
    }


}
