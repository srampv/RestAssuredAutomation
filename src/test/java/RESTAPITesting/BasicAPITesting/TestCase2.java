package RESTAPITesting.BasicAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

    @Test
    public void testCase2(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response Body is "+response.getBody().asString());
        System.out.println("Status code "+response.getStatusCode());
        System.out.println("response.getTime()");
        System.out.println("response statusline "+response.statusLine());
        System.out.println("header contentType is "+response.getHeader("content-type"));

        Assert.assertEquals(200,response.getStatusCode());

    }
}
