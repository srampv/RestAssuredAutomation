package com.seo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_Get_Request {

    @Test
    public void ListUsersValidation(){

        RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users?page=2");
        System.out.println("Response body is "+response.asPrettyString());
        Assert.assertEquals(200,response.statusCode());
        int sytrperpage = response.jsonPath().get("per_page");
        Assert.assertEquals(6,sytrperpage);
        String strheadeContent = response.header("Content-Type");
        System.out.println("strheadeContent is "+strheadeContent);
        Assert.assertEquals("application/json; charset=utf-8",strheadeContent);


    }
}
