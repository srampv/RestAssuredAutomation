package RESTAPITesting.DemoQAAPI;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;


public class WaetherAPI {


    @Test
    public void getValidCityWeather(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(200,response.statusCode());

    }

    @Test
    public void inValidCityWeatherDetails(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/78789798798");
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(400,response.statusCode());

    }

    @Test
    public void getAllHeaders(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        Headers headers = response.headers();
        for(Header header:headers){
            System.out.println("header data is "+"Key is "+header.getName()+"      "+header.getValue());
        }

        Assert.assertEquals("application/json; charset=utf-8",response.getHeader("Content-Type"));
        Assert.assertEquals("keep-alive",response.getHeader("Connection"));

    }

    @Test
    public void requestBodyValidation(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        String strResponse = response.body().asString();
        Assert.assertEquals(true,strResponse.contains("Hyderabad"));
        Assert.assertEquals(true,strResponse.contains("scattered clouds"));
    }


    @Test
    public void extractingNodefromJsonPathValidation(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals("Hyderabad",jsonPath.get("City"));
        Assert.assertEquals("132 Degree celsius",jsonPath.get("Temperature"));
        Assert.assertEquals("105 Percent",jsonPath.get("Humidity"));

    }
}
