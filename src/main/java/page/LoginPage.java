package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //locators
    //Validation(Assertions)
    //actions

    private final By usernameFiled = By.id("user-name");
    private final By passwordFiled = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login test using username is {username} and password is {password}")
    public LoginPage loginPage(String username, String password) {

        utils.type(usernameFiled, username);
        utils.type(passwordFiled, password);
        utils.click(loginButton);
//        driver.findElement(usernameFiled).sendKeys(username);
//        driver.findElement(passwordFiled).sendKeys(password);
//        driver.findElement(loginButton).click();
        return this;

    }

    public LoginPage assertErrorMessage(String expectedMessage) {
        String actualText = driver.findElement(errorMessage).getText();
        Assert.assertTrue(actualText.contains(expectedMessage), "Expected error: " + expectedMessage + " but found: " + actualText);
        return this;
    }

    public HomePage isLoggedIn(String expectedUrlPart) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart), "logged In");
        return new HomePage(driver);
    }


}
