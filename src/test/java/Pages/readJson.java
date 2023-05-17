package Pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class readJson {

    public List<HashMap<String,String>> getJsonToMap() throws IOException {


       String jsonfile = FileUtils
                .readFileToString
                        (new File(System.getProperty("user.dir") + "//src/test/java//resources//data.json"),
                                StandardCharsets.UTF_8);

        ObjectMapper map = new ObjectMapper();
        List<HashMap<String,String>> data = map.readValue(jsonfile, new TypeReference<List<HashMap<String,String>>>() {
        });

        return data;



    }
}
