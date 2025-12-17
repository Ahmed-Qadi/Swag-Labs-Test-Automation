package page_test;

import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutAddInfoPage;
import utils.readers.JsonReader;

public class CheckoutAddInfoTest extends BaseTest{


    private CartPage cartPage;
    private CheckoutAddInfoPage checkoutPage;
    private final String product1 = JsonReader.getJsonContent("product_locator_1");
    private final String fName = JsonReader.getJsonContent("first_name");
    private final String lName = JsonReader.getJsonContent("last_name");
    private final String zip = JsonReader.getJsonContent("zip");


    @Test
    public void CheckoutInformationSubmissionTest(){
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage =cartPage.validateNavigateToCheckout();
        checkoutPage.fillCheckoutInformationAndGoToOverview(fName,lName,zip)
                .verifyUserIsOnOverviewPage();
    }
    @Test
    public void CheckoutCancelNavigationTest(){
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage =cartPage.validateNavigateToCheckout();
        checkoutPage.cancelCheckout()
                .verifyUserIsOnCartPage();
    }

    @Test
    public void validateInvalidFirstname(){
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage =cartPage.validateNavigateToCheckout();
        checkoutPage.fillCheckoutInformationAndGoToOverview("",lName,zip)
                .assertCheckoutErrorMessage();
    }
    @Test
    public void validateInvalidLastname(){
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage =cartPage.validateNavigateToCheckout();
        checkoutPage.fillCheckoutInformationAndGoToOverview(fName,"",zip)
                .assertCheckoutErrorMessage();
    }

    @Test
    public void validateInvalidZip(){
        cartPage = homePage
                .addToCart(product1)
                .validateAddToCartIcon()
                .navigateToCartPage();
        checkoutPage =cartPage.validateNavigateToCheckout();
        checkoutPage.fillCheckoutInformationAndGoToOverview(fName,lName,"")
                .assertCheckoutErrorMessage();
    }



}
