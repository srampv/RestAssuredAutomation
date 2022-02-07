package com.seo;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicAuthenticatedAutomation {

    @Test
    public void basicAuthenticationUserTest(){

        RestAssured.baseURI="https://bookstore.toolsqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        String credentials = "TOOLSQA-Test:Test@@123";
        //Baisc Authentication
        PreemptiveBasicAuthScheme basicAuth =new PreemptiveBasicAuthScheme();
        basicAuth.setUserName("TOOLSQA-Test");
        basicAuth.setPassword("Test@@123");

        RestAssured.authentication=basicAuth;


        Response response = httpRequest.request(Method.GET,"/BookStore/v1/Books");
        System.out.println(response.getBody().prettyPrint());



    }


}
