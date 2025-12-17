package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.readers.PropertyReader;

public class OverviewPage extends BasePage {


    By finishBtn = By.id("finish");
    By cancelBtn = By.id("cancel");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage cancelOverview(){
        utils.click(cancelBtn);
        return this;
    }

    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(driver.getCurrentUrl().
                contains(PropertyReader.getProperty("homePageUrl")));
    }

    public OverviewPage confirmOverview(){
        utils.click(finishBtn);
        return this;
    }

    public OverviewPage verifyUserIsOnCompletePage() {
        Assert.assertTrue(driver.getCurrentUrl().
                contains(PropertyReader.getProperty("completePageUrl")));
        return this;
    }
}
