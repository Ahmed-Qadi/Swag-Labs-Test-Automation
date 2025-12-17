package page;

import header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.readers.PropertyReader;

public class CartPage extends BasePage{

    By continueShoppingBtn = By.id("continue-shopping");
    By checkoutBtn = By.id("checkout");



    HeaderComponent headerComponent;
    public CartPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
    }


    public CartPage removeFromCart(String productName) {
        // getCartValueBeforeDelete = headerComponent.getCartNumber();
        utils.captureCartValueBeforeDelete();
        String path = "[id^='remove'][id$='"+productName+"']";
        utils.click(By.cssSelector(path));
        return this;
    }


    public void validateRemoveProductFromCartPage() {
        //String cartIconText = driver.findElement(shoppingCartIcon).getText();
        utils.validateCartDecrement();

    }

    public void validateNavigateToHome(){
        utils.click(continueShoppingBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("homePageUrl")));
    }

    public CheckoutAddInfoPage validateNavigateToCheckout(){
        utils.click(checkoutBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("checkoutPageUrl")));
        return new CheckoutAddInfoPage(driver);
    }


}
