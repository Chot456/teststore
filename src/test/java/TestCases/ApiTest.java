package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Hooks;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest extends Hooks {
    public ApiTest() throws IOException {
        super();
    }

    @Test
    public void getSampleAPIData() throws Exception {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

}
