package page_test;

import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutAddInfoPage;
import page.OverviewPage;
import utils.readers.JsonReader;

public class OverviewTest extends BaseTest {

    private CartPage cartPage;
    private CheckoutAddInfoPage checkoutPage;
    private OverviewPage overviewPage;
    private final String product1 = JsonReader.getJsonContent("product_locator_1");
    private final String fName = JsonReader.getJsonContent("first_name");
    private final String lName = JsonReader.getJsonContent("last_name");
    private final String zip = JsonReader.getJsonContent("zip");

    @Test
    public void confirmationTC() {
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage = cartPage.validateNavigateToCheckout();
        overviewPage = checkoutPage.fillCheckoutInformationAndGoToOverview(fName, lName, zip)
                .verifyUserIsOnOverviewPage();
        overviewPage.confirmOverview().verifyUserIsOnCompletePage();

    }

    @Test
    public void cancelTC() {
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage = cartPage.validateNavigateToCheckout();
        overviewPage = checkoutPage.fillCheckoutInformationAndGoToOverview(fName, lName, zip)
                .verifyUserIsOnOverviewPage();
        overviewPage.cancelOverview().verifyUserIsOnCartPage();

    }
}
