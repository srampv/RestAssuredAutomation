package com.seo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC004_Get_Request {

    @Test

    public void getHeaderDetails(){

        RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users?page=2");
        String strresponseBody = response.getBody().prettyPrint();
        Headers allHeaderDetails = response.headers();
        for(Header header:allHeaderDetails){
            System.out.println(header.getName()+"        "+header.getValue());


        }



    }
}
