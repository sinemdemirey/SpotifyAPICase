package core;

import com.google.common.io.Resources;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class BaseFunctions {

    public static JSONObject readJsonFile(String fileName) throws IOException {

        URL jsonFile = Resources.getResource(fileName+".json");
        String json = Resources.toString(jsonFile, Charset.defaultCharset());
        JSONObject jsonObject = new JSONObject( json );
        return jsonObject;

    }

}
