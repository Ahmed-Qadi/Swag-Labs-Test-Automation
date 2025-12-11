package page_test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = WebDriverFactory.initDriver(PropertyReader.getProperty("browser"));
        driver.get(PropertyReader.getProperty("base_url"));
    }

    @Test
    void validateLogin() {
        new LoginPage(WebDriverFactory.getDriver())
                .loginPage(JsonReader.getJsonContent("username"), JsonReader.getJsonContent("password"))
                .isLoggedIn(PropertyReader.getProperty("expectedUrlForLoggedUser"));

    }


    @AfterMethod
    void tearDown() {
        WebDriverFactory.quitDriver();
    }

}
