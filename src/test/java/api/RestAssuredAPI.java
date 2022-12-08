package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

public class RestAssuredAPI {

    @BeforeAll
    public void setup() {
        //RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    @Test
    public void createCustomer() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();

        // Create JSON Request
        JSONObject requestParams = new JSONObject();
        //requestParams.put("id", "0312");
        requestParams.put("name", "Fingur Mueler");
        requestParams.put("email", "Whackadoo_peekachu@beelz.biz");
        requestParams.put("gender", "female");
        requestParams.put("status", "inactive");

        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");
        request.body(requestParams.toJSONString());
        System.out.println(requestParams.toJSONString());

        Response response = request.post("/users");  // "/users?access-token=Bearer"
        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());
    }
}
