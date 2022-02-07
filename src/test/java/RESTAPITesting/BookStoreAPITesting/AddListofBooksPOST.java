package RESTAPITesting.BookStoreAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class AddListofBooksPOST {

    @Test
    public void addBooksList(){
        RestAssured.baseURI="https://demoqa.com/BookStore/v1";
        RequestSpecification httpRequest =RestAssured.given();
        JSONObject requestparams = new JSONObject();
        requestparams.put("userId","user345");
        requestparams.put("collectionOfIsbns.isbn","1234567890");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestparams.toJSONString());
        Response response= httpRequest.post("/Books");
        System.out.println(response.prettyPrint());


    }
}
