package page_test;

import driver.WebDriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class LoginTest extends BaseTest {

    final String  username = JsonReader.getJsonContent("username");
    final String password = JsonReader.getJsonContent("password");


    @BeforeMethod
    public void setup() {
        WebDriverFactory.initDriver(PropertyReader.getProperty("browser"));
        WebDriverFactory.getDriver().get(PropertyReader.getProperty("base_url"));
    }

    @Test
    void validateLogin() {
        new LoginPage(WebDriverFactory.getDriver())
                .loginPage(username, password)
                .isLoggedIn(PropertyReader.getProperty("homePageUrl"));


    }

    @Test
    void validateInvalidUsername() {
        new LoginPage(WebDriverFactory.getDriver())
                .loginPage("wrongUser", JsonReader.getJsonContent("password"))
                .assertErrorMessage("Username and password do not match");
    }

    @Test
    void validateInvalidPassword() {
        new LoginPage(WebDriverFactory.getDriver())
                .loginPage(JsonReader.getJsonContent("username"), "wrongPass")
                .assertErrorMessage("Username and password do not match");
    }

    @Test
    void validateEmptyCredentials() {
        new LoginPage(WebDriverFactory.getDriver())
                .loginPage("", "")
                .assertErrorMessage("Username is required");
    }


}
