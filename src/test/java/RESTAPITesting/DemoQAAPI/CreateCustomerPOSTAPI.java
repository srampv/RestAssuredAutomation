package RESTAPITesting.DemoQAAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class CreateCustomerPOSTAPI {

    @Test
    public void creteCustomer() {

        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("FirstName","Selvi");
        requestParams.put("LastName", "Naidu");

        requestParams.put("UserName", "simpleselvi001");
        requestParams.put("Password", "password1");
        requestParams.put("Email",  "selviuser@gmail.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        Response resonse = httpRequest.request(Method.POST,"register");
        System.out.println("response body is "+resonse.prettyPrint());

    }

}
