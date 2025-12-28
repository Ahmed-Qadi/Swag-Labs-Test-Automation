package listeners;

import driver.WebDriverFactory;
import org.testng.*;
import utils.AllureUtils;
import utils.ScreenShotUtils;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

import static utils.AllureUtils.allureClearStepCache;
import static utils.AllureUtils.setAllureEnvironment;

public class TestNGListeners implements IExecutionListener, IInvokedMethodListener {

    public void onExecutionStart() {
        PropertyReader.loadProperties();
        new JsonReader("/data");
        allureClearStepCache();
        setAllureEnvironment();
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()&& testResult.getStatus() == ITestResult.FAILURE)
            ScreenShotUtils.takeScreenshot(WebDriverFactory.getDriver(), testResult.getName());
    }


}
