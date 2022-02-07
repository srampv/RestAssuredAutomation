package RESTAPITesting.Framework.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.runner.Request;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;

import java.util.Collections;
import java.util.Map;


public class RestAPIutils {


    public Response get(String URL){

        Response strresponse = RestAssured.given()
                .header("Authorization","Bearer")
                .accept(ContentType.JSON)
                .log().all()
                .get(URL);
        //strresponse.prettyPrint();

        return strresponse;
    }


    public Response getWithPathParam(String URL,String key,int id){

        Response response = RestAssured.given().urlEncodingEnabled(false)
                .baseUri(URL)
                .pathParam("key",id)
                .header("Authorization","Bearer")
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/{key}");
                //.get(URL);
        response.prettyPrint();

        return response;
    }

     public Response getwithMutiplePathParams(String URL, Map<String,Integer> PathParamsmap){

        Response response = RestAssured.given().urlEncodingEnabled(false)
                //.baseUri(URL)
                .pathParams(PathParamsmap)
                .header("Authorization","Bearer")
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(URL+"/{PathParamsmap}");
         response.prettyPrint();

         return response;

     }

     public Response post(String URL, String requestBody){
         return  RestAssured.given().header("Content-Type","application/json")
                 .body(requestBody)
                 .log().all()
                 .when().post(URL);


     }


}
