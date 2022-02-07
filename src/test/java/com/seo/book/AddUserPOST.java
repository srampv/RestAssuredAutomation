package com.seo.book;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.annotations.Test;

public class AddUserPOST {

    @Test
    public void addUser(){
        RestAssured.baseURI="https://demoqa.com/Account/v1";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestparams = new JSONObject();
        requestparams.put("userName","user3456");
        requestparams.put("password","Password@3456");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestparams.toJSONString());
        Response response = httpRequest.post("/User");
        System.out.println("response is "+ response.prettyPrint());

    }


}
