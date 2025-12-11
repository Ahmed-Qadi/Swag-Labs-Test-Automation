package listeners;

import org.testng.IExecutionListener;
import utils.readers.JsonReader;
import utils.readers.PropertyReader;

public class TestNGListeners implements IExecutionListener {

    public void onExecutionStart() {
        PropertyReader.loadProperties();
        new JsonReader("/data");
    }

}
