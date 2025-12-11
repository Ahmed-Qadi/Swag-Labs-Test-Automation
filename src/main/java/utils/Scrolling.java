package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Scrolling {

    WebDriver driver;


    public Scrolling(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(By locator){
        WebElement element = driver.findElement(locator);
        new Actions(driver).scrollToElement(element);
    }
}
