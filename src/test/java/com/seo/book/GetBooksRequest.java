package com.seo.book;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetBooksRequest {

    @Test

    public void queryParamTesting(){

        RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest =  RestAssured.given();
        Response response =httpRequest.queryParam("ISBN","9781449325862").get("/Book");
        System.out.println(response.getBody().prettyPrint());
        JsonPath jsonpath = new JsonPath(response.body().asString());
        System.out.println("Titls is "+jsonpath.get("title"));
        System.out.println("Author is "+jsonpath.get("author"));



    }
}
