package RESTAPITesting.TeknosysAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetIPDataAPI {

    @Test
    public void getIPData(){

        RestAssured.baseURI="http://192.168.1.30:9090/ip/get";
        RequestSpecification httpRequest = RestAssured.given();
        RequestSpecification headerspecification = httpRequest.header("api-key","9751acb06414d61adcc357a05439a4506b9e1e45744bff8d6b0a74a0625").when();
        Response response = headerspecification.when().get("/IP/66").then().contentType("application/json").extract().response();

        System.out.println("response body is "+response.getBody().prettyPrint());


    }



}
