package RESTAPITesting.BasicAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC001_Get_Request {

    @Test
    public void getUserDetails(){
        //specify base URI

        RestAssured.baseURI="https://reqres.in/api";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/users?page=2");
        System.out.println("response body is "+ response.asString());
        System.out.println("response status code is "+response.statusCode());
        Assert.assertEquals(200,response.statusCode());
        String strstatusLine = response.statusLine();
        System.out.println("strstatusLine is "+strstatusLine);
        Assert.assertEquals("HTTP/1.1 200 OK",strstatusLine);

    }

}
