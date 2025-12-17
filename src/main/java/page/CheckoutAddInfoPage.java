package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.readers.PropertyReader;

public class CheckoutAddInfoPage extends BasePage {
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By cancelBtn = By.id("cancel");
    By errorMessage = By.cssSelector("h3[data-test='error']");



    public CheckoutAddInfoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutAddInfoPage fillCheckoutInformationAndGoToOverview(String fName, String lName, String zip) {
        utils.type(firstName, fName);
        utils.type(lastName, lName);
        utils.type(postalCode, zip);

        utils.click(continueBtn);
        return this;
    }

    public OverviewPage verifyUserIsOnOverviewPage() {
        Assert.assertTrue(driver.getCurrentUrl().
                contains(PropertyReader.getProperty("overviewPageUrl")));
        return new OverviewPage(driver);
    }

    public CheckoutAddInfoPage cancelCheckout(){
        utils.click(cancelBtn);
        return this;
    }



    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(driver.getCurrentUrl().
                contains(PropertyReader.getProperty("cartPageUrl")));
    }

    public void assertCheckoutErrorMessage(){

        Assert.assertNotNull(utils.getText(errorMessage));

    }


}
