package page;

import org.openqa.selenium.WebDriver;
import utils.Utils;

public class BasePage {

    protected WebDriver driver;
    protected Utils utils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

}
