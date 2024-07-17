package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.JsonReader;
import base.ExtentManager;
import base.Hooks;

public class DataDriverTest extends Hooks {
    public DataDriverTest() throws IOException {
        super();
    }

    @Test
    public void getDataFromJsonFile() throws Exception {

        // ExtentManager.log("data driven test...");

        String username = JsonReader.getJsonValue("test1", "username");

        System.out.println(username);

        // ExtentManager.pass("Success");
    }
}
