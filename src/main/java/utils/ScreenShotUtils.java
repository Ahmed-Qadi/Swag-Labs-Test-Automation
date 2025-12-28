package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenShotUtils {

    //this method is used to take screenshot and save it to the specified location
    // and attach it to the Allure report
    //and called this function in listeners
    public static void takeScreenshot(WebDriver driver, String name) {
        // Implementation for taking screenshot
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("test_report/screenshots/" + name + ".png");
            FileUtils.copyFile(screenshot, destination);
            //
            AllureUtils.addAttachmentToAllureReport(name, destination.getPath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
