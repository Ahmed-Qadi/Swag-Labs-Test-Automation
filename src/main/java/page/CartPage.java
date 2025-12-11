package page;

import header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{


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


    public CartPage validateRemoveProductFromCartPage() {
        //String cartIconText = driver.findElement(shoppingCartIcon).getText();
        utils.validateCartDecrement();
        return this;
    }


}
