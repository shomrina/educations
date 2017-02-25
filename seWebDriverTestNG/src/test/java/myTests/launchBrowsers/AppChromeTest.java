package myTests.launchBrowsers;


import Pages.LoginAdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppChromeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstChromeTest() {
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
