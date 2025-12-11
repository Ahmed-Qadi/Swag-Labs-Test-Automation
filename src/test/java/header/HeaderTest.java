package header;

import driver.WebDriverFactory;
import header.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class HeaderTest {


    @BeforeMethod
    public void setup() {


        WebDriverFactory.initDriver(PropertyReader.getProperty("browser"));
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(PropertyReader.getProperty("base_url"));

        new LoginPage(WebDriverFactory.getDriver())
                .loginPage(JsonReader.getJsonContent("username"), JsonReader.getJsonContent("password"))
                .isLoggedIn(PropertyReader.getProperty("expectedUrlForLoggedUser"));

    }

    @Test()
    void validateLogoutTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .validateLogout();
    }

    @Test
    void validateResetAppStateTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .validateResetAppState();
    }


    @Test
    void validateNavigateToCartPageTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .validateNavigateToCartPage();
    }



    @AfterMethod
    void teardown() {
        WebDriverFactory.quitDriver();
    }


}
