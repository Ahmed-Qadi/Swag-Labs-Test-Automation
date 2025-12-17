package header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.BasePage;
import page.CartPage;
import utils.readers.PropertyReader;

public class HeaderComponent extends BasePage {

    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutBtn = By.id("logout_sidebar_link");
    private final By resetAppStateBtn = By.id("reset_sidebar_link");
    private final By shoppingCartIconBtn = By.className("shopping_cart_link");




    public HeaderComponent(WebDriver driver) {
        super(driver);
    }




    public void validateLogout() {
        utils.click(burgerMenu);
        utils.click(logoutBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("loginPageUrl")));
    }

    public void validateResetAppState(){
        utils.click(burgerMenu);
        utils.click(resetAppStateBtn);
        Assert.assertEquals(utils.getCartNumber(),0);;

    }

    public CartPage navigateToCartPage(){
        utils.click(shoppingCartIconBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains(PropertyReader.getProperty("cartPageUrl")));
        return new  CartPage(driver);
    }


}
