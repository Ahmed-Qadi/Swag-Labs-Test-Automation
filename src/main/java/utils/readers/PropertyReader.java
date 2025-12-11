package utils.readers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {


    public static void loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> propertyFiles;
            propertyFiles = FileUtils.listFiles(
                    new File("src/main/resources"),
                    new String[]{"properties"},
                    true);

            propertyFiles.forEach(file -> {
                try {
                    properties.load(FileUtils.openInputStream(file));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);

            });


        }catch (Exception e) {
            System.out.println("Error loading properties: " + e.getMessage());

        }



    }

    public static String getProperty(String key){
        return System.getProperty(key);
    }


}
