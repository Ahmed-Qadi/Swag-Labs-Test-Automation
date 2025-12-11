package page_test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class CartTest {

    WebDriver driver;

    @BeforeMethod
    public void init() {
        WebDriverFactory.initDriver(PropertyReader.getProperty("browser"));
        driver = WebDriverFactory.getDriver();
        driver.get(PropertyReader.getProperty("base_url"));
        new LoginPage(driver)
                .loginPage(JsonReader.getJsonContent("username"), JsonReader.getJsonContent("password"))
                .isLoggedIn(PropertyReader.getProperty("expectedUrlForLoggedUser"));

    }

    @Test
    public void validateRemoveProductFromCartPage() {
        new HomePage(driver)
                .addToCart(JsonReader.getJsonContent("product_locator_1"))
                .validateAddToCartIcon()
                .validateNavigateToCartPage()
                .removeFromCart(JsonReader.getJsonContent("product_locator_1"))
                .validateRemoveProductFromCartPage();


    }




    @AfterMethod
    void teardown() {
        WebDriverFactory.quitDriver();
    }


}
