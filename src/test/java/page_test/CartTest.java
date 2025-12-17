package page_test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.BasePage;
import page.CartPage;
import page.HomePage;
import page.LoginPage;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class CartTest extends BaseTest {

    private CartPage cartPage;

    private final String product1 = JsonReader.getJsonContent("product_locator_1");


    @Test
    public void assertRemoveProductFromCartPage() {
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();

        cartPage
                .removeFromCart(product1)
                .validateRemoveProductFromCartPage();
    }

    @Test
    public void assertUserNavigatedToHome() {

        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();

        cartPage.validateNavigateToHome();

    }
    @Test
    public void assertUserNavigatedToCheckout() {

        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();

        cartPage.validateNavigateToCheckout();

    }







}
