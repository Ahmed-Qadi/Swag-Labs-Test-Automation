package listeners;

import org.testng.IExecutionListener;
import utils.AllureUtils;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

import static utils.AllureUtils.allureClearStepCache;

public class TestNGListeners implements IExecutionListener {

    public void onExecutionStart() {
        PropertyReader.loadProperties();
        new JsonReader("/data");
        allureClearStepCache();
    }

}
