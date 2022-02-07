package RESTAPITesting.Framework;

import RESTAPITesting.Framework.POJO.VideoGamePOJOClass;
import RESTAPITesting.Framework.Utils.RestAPIutils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SamplePostTest {

    @Test
    public void samplePostTest1(){
        RestAPIutils restAPIutils = new RestAPIutils();
        String strURL = "http://localhost:8080/app/videogames";
        VideoGamePOJOClass videogames  =new VideoGamePOJOClass();
        Map<String,String > testData = new HashMap<String,String >();
        testData.put("id", "13");
        testData.put("name", "Beetanew");
        testData.put("releaseDate", "2022-02-04T00:31:35.589Z");
        testData.put("reviewScore", "21");
        testData.put("category",  "Driving");
        testData.put("rating","Global");
        String strpayLoad = videogames.getVideoGamePayload(testData);
        Response strResponse = restAPIutils.post(strURL,strpayLoad);
        strResponse.prettyPrint();

    }
}
