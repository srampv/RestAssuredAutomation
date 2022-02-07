package RESTAPITesting.BasicAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_Get_Request {

    @Test
    public void ResponseBodyValidation(){

        RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users/2");
        String strresponseBody = response.body().prettyPrint();
        System.out.println("strresponseBody is "+strresponseBody);
        boolean bflag = strresponseBody.contains("janet.weaver@reqres.in");
        System.out.println("bflag is "+bflag);
        Assert.assertTrue(strresponseBody.contains("janet.weaver@reqres.in"),"true");
        Assert.assertTrue(strresponseBody.contains("Janet"),"true");

        //capture data for every node

        JsonPath jsonPath = response.jsonPath();
        System.out.println("email data is "+jsonPath.get("data.email"));
        System.out.println("firstname data is "+jsonPath.get("data.first_name"));
        System.out.println("last name data is "+jsonPath.get("data.last_name"));
        System.out.println("Avatar data is "+jsonPath.get("data.avatar"));
        //After write the assertions









    }
}
