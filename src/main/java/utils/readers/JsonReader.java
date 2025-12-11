package utils.readers;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    static  private String jsonContent;
    public  JsonReader(String fileName) {

        try {
            JSONObject object = (JSONObject) new JSONParser()
                    .parse(new FileReader("src/main/resources" + fileName + ".json"));
            jsonContent = object.toJSONString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static public String getJsonContent(String key) {
        try {
            return JsonPath.from(jsonContent).getString(key);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
