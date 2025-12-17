package header;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page_test.BaseTest;


public class HeaderTest extends BaseTest {

    WebDriver driver;
    @Test()
    void validateLogoutTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .validateLogout();
    }

    @Test
    void validateResetAppStateTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .validateResetAppState();
    }


    @Test
    void validateNavigateToCartPageTC() {
        new HeaderComponent(WebDriverFactory.getDriver())
                .navigateToCartPage();
    }


}
