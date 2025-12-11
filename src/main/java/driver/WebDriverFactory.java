package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {


    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();//for parallel execution

    private static AbstractDriver getDriver(String driverType) {

        return switch (driverType) {
            case "chrome" -> new ChromeFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException("Browser not supported " + driverType);
        };

    }

    public static WebDriver initDriver(String browser){
        WebDriver driver = ThreadGuard.protect(getDriver(browser).createDriver());
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();

    }

    public static void quitDriver(){

        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }

    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
