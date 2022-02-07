package com.seo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;
import org.testng.annotations.Test;

public class TC006_Post_Request {

    @Test
    public void loginValidation(){

        RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject reqParams = new JSONObject();
        reqParams.put("email","eve.holt@reqres.in");
        reqParams.put("password","cityslicka");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(reqParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/login");
        String strresponse = response.getBody().prettyPrint();
        System.out.println("strresponse is "+strresponse);

        //validations

        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals("QpwL5tke4Pnpja7X4",response.jsonPath().get("token"));

        Assert.assertEquals(true,strresponse.contains("token"));


    }
}
