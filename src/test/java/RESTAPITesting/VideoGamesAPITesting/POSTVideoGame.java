package RESTAPITesting.VideoGamesAPITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class POSTVideoGame {

    @Test
    public void addVideoGame(){

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", 12);
        requestParams.put("name", "alphanew");
        requestParams.put("releaseDate", "2022-02-04T00:31:27.589Z");
        requestParams.put("reviewScore", 10);
        requestParams.put("category",  "Shooter");
        requestParams.put("rating","Universal");
        Response response = given().when().baseUri("http://localhost:8080/app/videogames")
                .header("Content-Type","application/json").body(requestParams.toJSONString()).post();

        response.prettyPrint();

    }


}
