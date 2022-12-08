package api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;


@SuppressWarnings("unchecked")
public class RestAssuredAPI {
    private int idField;
    private String name;
    private String email;
    private String gender;
    private String status;

    @BeforeTest
    public void setup() {
        name = "Wilbur Wonkee";
        gender = "male";
        status = "active";
    }

    @AfterTest
    public void teardown() {
    }

    @Test
    public void createUser() {
        email = "Birdsong_Glee@goofred" + randomNumberGenerator() +".biz";
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();

        // Create JSON Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name );
        requestParams.put("email", email);
        requestParams.put("gender", gender);
        requestParams.put("status", status);

        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");
        request.body(requestParams.toJSONString());
        System.out.println(requestParams.toJSONString());

        Response response = request.post("/users");
        ResponseBody body = response.body();
        Gson gson = new Gson();
        JSONSuccessResponse responseBody = gson.fromJson(body.asPrettyString(), JSONSuccessResponse.class);
        idField = responseBody.id;

        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void updateUser() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();

        // Create JSON Request
        JSONObject requestParams = new JSONObject();
        //requestParams.put("id", "2120");
        requestParams.put("name", "Billy Wadsworth");
        requestParams.put("email", "Whackadoo_peekachu@beelz.biz");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");

        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");
        request.body(requestParams.toJSONString());
        System.out.println(requestParams.toJSONString());

        //Response response = request.patch("/users/37");  // "/users"
        String body = "{ \"id\": 2146, \"name\": \"Billy Wadsworth\", \"email\": \"Birdsong_Glee@beelz.biz\", \"gender\": \"male\", \"status\": \"active\"}";
        Response response = request.body(body).put("/users/37/Birdsong_Glee@beelz.biz");
        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());

    }

    @Test
    public void listUsers() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");

        Response response = request.get("/users");
        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getSpecificUser() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");

        Response response = request.queryParam("id", idField).get("/users");
        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());
    }

    @Test
    public void deleteUser() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification request = RestAssured.given();
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer e0f831083e7dc82c0d4225347f8bc8f4759bb3fda7b26368ca0fc95856b53681");

        String body = "{ \"id\": 2171, \"name\": \"Fingur Mueler\", \"email\": \"Birdsong_Glee@beelz1.biz\", \"gender\": \"female\", \"status\": \"inactive\"}";
        Response response = request.body(body).delete("/users/44");
        System.out.println("The status received is: " + response.statusLine());
        System.out.println("Response Body -> " + response.body().asPrettyString());
    }

    /*
     * Private methods
     */
    private int randomNumberGenerator() {
        return (int)(Math.random() * (999 - 100) + 100);
    }
}
