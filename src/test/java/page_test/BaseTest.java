package page_test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.LoginPage;
import utils.ScreenShotUtils;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class BaseTest {

    protected HomePage homePage;

    @BeforeMethod
    public void setup() {

        WebDriverFactory.initDriver(PropertyReader.getProperty("browser"));
        WebDriverFactory.getDriver().get(PropertyReader.getProperty("base_url"));


        homePage = new LoginPage(WebDriverFactory.getDriver())
                .loginPage(JsonReader.getJsonContent("username"), JsonReader.getJsonContent("password"))
                .isLoggedIn(PropertyReader.getProperty("homePageUrl"));
    }

    @AfterMethod
    public void teardown() {
        WebDriverFactory.quitDriver();
    }
}
