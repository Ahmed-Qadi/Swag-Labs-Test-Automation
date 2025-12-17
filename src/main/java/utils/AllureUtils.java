package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class AllureUtils {

    public static void allureClearStepCache() {
        // This method is cleaning up Allure step cache by deleting temporary files.
        FileUtils.deleteQuietly(new File("test_report/allure-results"));

    }


}
