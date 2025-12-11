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
                .loginPage(JsonReader.getJsonContent("username"),
                        JsonReader.getJsonContent("password"))
                .isLoggedIn(PropertyReader.getProperty("expectedUrlForLoggedUser"));

    }
    @Test
    void validateInvalidUsername() {
        new LoginPage(driver)
                .loginPage("wrongUser", JsonReader.getJsonContent("password"))
                .assertErrorMessage("Username and password do not match");
    }
    @Test
    void validateInvalidPassword() {
        new LoginPage(driver)
                .loginPage(JsonReader.getJsonContent("username"), "wrongPass")
                .assertErrorMessage("Username and password do not match");
    }
    @Test
    void validateEmptyCredentials() {
        new LoginPage(driver)
                .loginPage("", "")
                .assertErrorMessage("Username is required");
    }


    @AfterMethod
    void tearDown() {
        WebDriverFactory.quitDriver();
    }

}
