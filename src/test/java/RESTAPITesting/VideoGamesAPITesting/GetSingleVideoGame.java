package RESTAPITesting.VideoGamesAPITesting;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetSingleVideoGame {

    @Test
    public void getVideoGameWithQueryParam(){
    Response response = given().accept(ContentType.JSON)
                        .param("id","2")
                        .param("name","Gran Turismo 3")
                        .when().get("http://localhost:8080/app/videogames/")
                        .then().extract().response();
    System.out.println("respone body is "+response.prettyPrint());
    JsonPath responsejsonpath = response.jsonPath();
    responsejsonpath.getList("name").contains("Theft");

    }
}
