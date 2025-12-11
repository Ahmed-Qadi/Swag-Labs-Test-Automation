package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Utils {




    private WebDriver driver;
    private final Wait wait;
    private final Scrolling scrolling;
    private int cartValueBeforeDelete;


    public Utils(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
        scrolling = new Scrolling(driver);
    }


    //Click
    public void click(By locator) {
        wait.fluentWait().until(d -> {
            try {
                scrolling.scrollToElement(locator);
                d.findElement(locator).click();
                return true;
            } catch (Exception e) {
                return false;
            }

        });

    }

    //Type
    public void type(By locator, String text) {

        wait.fluentWait().until(d -> {
            scrolling.scrollToElement(locator);
            d.findElement(locator).sendKeys(text);
            return true;
        });

    }

    //Get Text
    public String getText(By locator) {
        return wait.fluentWait().until(
                d -> {
                    try {
                        scrolling.scrollToElement(locator);
                        return d.findElement(locator).getText();

                    } catch (Exception e) {
                        return "";
                    }
                }
        );

    }//Get Text
    public int getTextAsInt(By locator) {
        return wait.fluentWait().until(
                d -> {
                    try {
                        scrolling.scrollToElement(locator);
                        String text = d.findElement(locator).getText();
                        return Integer.parseInt(text);

                    } catch (NoSuchElementException e) {
                        return 0;
                    }
                }
        );

    }
    public int getCartNumber() {
        final By shoppingCartIcon = By.xpath("//span[@class  ='shopping_cart_badge']");

        return getTextAsInt(shoppingCartIcon);
    }

    public void captureCartValueBeforeDelete() {
        cartValueBeforeDelete = getCartNumber();
    }
    public void validateCartDecrement() {
        int current = getCartNumber();
        Assert.assertEquals(current, cartValueBeforeDelete - 1);
    }






}
