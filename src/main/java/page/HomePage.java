package page;

import header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Utils;

import java.util.List;


public class HomePage extends BasePage{

    private final By productsPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By sortDropdown = By.className("product_sort_container");
    private int getCartValueBeforeDelete;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private List<Double> getProductsPrices() {
        return driver.findElements(productsPrice).stream()
                .map(priceElement -> priceElement.getText().replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public HomePage verifyPriceSortedHighToLowe() {
        List<Double> prices = getProductsPrices();
        for (int i = 0; i < prices.size() - 1; i++) {

            Assert.assertTrue(prices.get(i) >= prices.get(i + 1));
        }

        return this;
    }

    public HomePage verifyPriceSortedLoweToHigh() {
        List<Double> prices = getProductsPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) <= prices.get(i + 1));
        }

        return this;
    }


    public HeaderComponent validateAddToCartIcon() {

        //String cartIconText = driver.findElement(shoppingCartIcon).getText();
        int cartIconText = utils.getCartNumber();
        Assert.assertTrue(cartIconText > 0);
        return new HeaderComponent(driver);
    }


    ////////////
    public HomePage selectSortingOption(String option) {
        new Select(driver.findElement(sortDropdown))
                .selectByValue(option);
        return this;
    }


    public HomePage validateRemoveFromCartIcon() {
        //String cartIconText = driver.findElement(shoppingCartIcon).getText();

        int cartIconText = utils.getCartNumber();
        Assert.assertEquals(cartIconText, (getCartValueBeforeDelete-1));
        return this;
    }

    public HomePage addToCart(String productName) {
        String path = "[id^='add'][id$='"+productName+"']";
        utils.click(By.cssSelector(path));
        return this;
    }
    public HomePage removeFromCart(String productName) {
       // getCartValueBeforeDelete = headerComponent.getCartNumber();
        utils.captureCartValueBeforeDelete();
        String path = "[id^='remove'][id$='"+productName+"']";
        utils.click(By.cssSelector(path));
        return this;
    }


    public HomePage validateRemoveProductFromHomePage() {
        //String cartIconText = driver.findElement(shoppingCartIcon).getText();
        utils.validateCartDecrement();
        return this;
    }

}
