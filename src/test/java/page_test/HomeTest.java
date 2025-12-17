package page_test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class HomeTest extends BaseTest{




    @Test
    void validateSortHighToLowTC() {
        new HomePage(WebDriverFactory.getDriver())
                .selectSortingOption(PropertyReader.getProperty("sortHighToLow"))
                .verifyPriceSortedHighToLowe();
    }


    @Test
    void validateSortLowToHighTC() {
        new HomePage(WebDriverFactory.getDriver())
                .selectSortingOption(PropertyReader.getProperty("sortLowToHigh"))
                .verifyPriceSortedLoweToHigh();
    }

    @Test
    void validateAddToCartTC() {
        new HomePage(WebDriverFactory.getDriver())
                .addToCart(JsonReader.getJsonContent("product_locator_1"))
                .validateAddToCartIcon();
    }

    @Test()
    void validateRemoveFromCartTC() {
        new HomePage(WebDriverFactory.getDriver())
                .addToCart(JsonReader.getJsonContent("product_locator_2"))
                .addToCart(JsonReader.getJsonContent("product_locator_3"))
                .removeFromCart(JsonReader.getJsonContent("product_locator_2"))
                .validateRemoveProductFromHomePage();
    }






}
