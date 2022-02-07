package RESTAPITesting.VideoGamesAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetVideoGamesList {

    Response response;
    List releaseDatesList = new ArrayList();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @BeforeTest
    public void baseURI(){
        RestAssured.baseURI="http://localhost:8080/app";
    }

    @Test
    public void getVideogamesList(){

        //Given accept the response in JSON format.
        //customized header
        Map<String,String> mapheaders= new HashMap<String ,String>();
        mapheaders.put("Accept","application/json ");
        response = given().headers(mapheaders).when().get("/videogames");
        System.out.println("response is "+response.prettyPrint());
    }

    @Test(dependsOnMethods = {"getVideogamesList"})
    public void testStatusCode(){
        /*
        int statusCode = given().when().accept(ContentType.JSON).get("/videogames")
                .thenReturn().statusCode();
        System.out.println("status code is "+statusCode);
        Assert.assertEquals(HttpStatus.SC_OK,statusCode);*/
        given().when().accept(ContentType.JSON).get("/videogames")
                .then().assertThat().statusCode(HttpStatus.SC_OK);
        System.out.println("response code from old method is "+response.statusCode());

    }

    @Test(dependsOnMethods = {"getVideogamesList"})
    public void testDateFormat() throws ParseException {

        JsonPath responseJsonData = response.jsonPath();

        releaseDatesList = responseJsonData.get("releaseDate");
        System.out.println("strreleaseDate is "+releaseDatesList.toString());
        System.out.println("dates list size  is "+releaseDatesList.size());
        boolean bflag = true;
        for(Object date:releaseDatesList){

            System.out.println("date parseds is "+dateFormat.parse(date.toString()));
            try {
                dateFormat.parse(date.toString());
                bflag =true;
                System.out.println("blag is "+bflag);
            }catch (ParseException pe){
                bflag = false;
            }
            finally {
                Assert.assertTrue("Release Date is a valid date", bflag);
            }
        }

    }

    @Test(dependsOnMethods = {"getVideogamesList"})
    public void releaseDateisFutureDate() throws ParseException {
        System.out.println("Ented in to check method");

        JsonPath responseJsonData = response.jsonPath();

        releaseDatesList = responseJsonData.get("releaseDate");
        System.out.println("date list size is "+releaseDatesList.size());
        for(Object dateObj:releaseDatesList){
            Date releaseDate = dateFormat.parse(dateObj.toString());
            Long l = releaseDate.getTime();
            Date current = new Date();
            Date next = new Date(l);
            if(next.after(current) || (next.equals(current))){
                System.out.println("The date is future day");
            } else {

                System.out.println("The date is older than current day");
            }

        }
    }

    @Test(dependsOnMethods = {"getVideogamesList"})
    public void getDrivingCategoryGamesList(){
        //hamcrest validations
        JsonPath jsonpath = response.jsonPath();
        System.out.println( jsonpath.get("category[3]").toString());
        response.then().body("category[0]",equalToIgnoringCase("Shooter"),"id[0]",equalTo(1)
        ,"name[0]",equalToIgnoringCase("Resident Evil 4"));
        //when list of data there need to use hasItem
        response.then().body("category",hasItem("Driving"));
        //validate the nested json
        response.then().body("category",hasItems("Driving","Shooter","Puzzle","Platform"));
        response.then().body("category",hasSize(10));

    }

@Test
    public void validateXMLContent(){

        given().accept(ContentType.XML).when().get("http://localhost:8080/app/videogames")
                .then().assertThat().body("videoGames.videoGame.id[0]",equalTo("1"),"videoGames.videoGame.name[1]",equalToIgnoringCase("Gran Turismo 3"));

    }
}
