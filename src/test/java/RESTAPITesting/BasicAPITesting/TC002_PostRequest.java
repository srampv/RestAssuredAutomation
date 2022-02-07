package RESTAPITesting.BasicAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_PostRequest {

    @Test
    public void CreateUser(){

        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification httpRequest = RestAssured.given();
        //To post some data to the server in json format
        //Request payload along with POST request
        JSONObject requestparams = new JSONObject();
        requestparams.put("name","JohnXYZ");
        requestparams.put("job","Employee");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestparams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/users");

        System.out.println("response body is "+response.getBody().prettyPrint());

        Assert.assertEquals(201,response.statusCode());

        String strActualname = response.jsonPath().get("name");
        Assert.assertEquals(strActualname,"JohnXYZ");

        String strJob = response.jsonPath().getString("job");
        Assert.assertEquals(strJob,"Employee");


    }
}
