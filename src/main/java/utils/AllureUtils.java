package utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import utils.readers.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {


    // This method is cleaning up Allure step cache by deleting temporary files.
    public static void allureClearStepCache() {
        FileUtils.deleteQuietly(new File("test_report/allure-results"));
    }

    // This method adds an attachment to the Allure report.
    public static void addAttachmentToAllureReport(String name, String path) {
        // Implementation for adding attachments to Allure report
        try {
            Allure.addAttachment(name, newInputStream(Path.of(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setAllureEnvironment(){

        allureEnvironmentWriter(
        ImmutableMap.<String,String>builder()
                .put("Browser", PropertyReader.getProperty("browser"))
                .put("URL", PropertyReader.getProperty("base_url"))
                .put("OS", PropertyReader.getProperty("os.name"))
                .build(),PropertyReader.getProperty("user.dir")+File.separator+"test_report/allure-results/"
        );
    }


}
