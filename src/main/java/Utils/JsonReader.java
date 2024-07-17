package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    /**
     * Reads the JSON file at the given path and returns the JSON array associated
     * with the key "data".
     *
     * @param filePath the path to the JSON file
     * @return the JSON array associated with the key "data"
     */
    public static JSONArray readJsonFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        JSONArray testData = null;

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            testData = (JSONArray) jsonObject.get("data");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return testData;
    }

    /**
     * Reads the JSON file at the given path and returns the value associated with
     * the given key.
     * 
     * @param filePath the path to the JSON file
     * @param key      the key to look up in the JSON file
     * @return the value associated with the given key, or null if the key is not
     *         present
     * @throws IOException    if an I/O error occurs
     * @throws ParseException if the JSON file is not well-formed
     */
    public static JSONObject getTestData(String key) throws IOException, ParseException {
        JSONArray testData = readJsonFile(Constants.localDir + "\\testData.json");
        for (Object o : testData) {
            JSONObject jsonObject = (JSONObject) o;
            if (jsonObject.containsKey(key)) {
                return (JSONObject) jsonObject.get(key);
            }
        }
        return null;
    }

    /**
     * Reads the JSON data associated with the given key and retrieves the specified
     * value.
     *
     * @param key   the key to look up in the JSON data
     * @param value the value to retrieve from the JSON data
     * @return the retrieved value corresponding to the key
     */
    public static String getJsonValue(String key, String value) throws IOException, ParseException {
        String testdata;
        JSONObject data = getTestData(key);
        testdata = (String) data.get(value);

        return testdata;
    }
}
