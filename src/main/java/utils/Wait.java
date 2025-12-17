package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

public class Wait {

    private  WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }



    public FluentWait<WebDriver> fluentWait(){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoreAll(ignoredArray());

    }


    private ArrayList<Class<? extends Exception>> ignoredArray(){

        ArrayList<Class<? extends Exception>> ignoreList = new ArrayList<>();
        ignoreList.add(NoSuchElementException.class);
        ignoreList.add(StaleElementReferenceException.class);
        ignoreList.add(ElementNotInteractableException.class);
        ignoreList.add(ElementClickInterceptedException.class);
        return ignoreList;

    }

}
