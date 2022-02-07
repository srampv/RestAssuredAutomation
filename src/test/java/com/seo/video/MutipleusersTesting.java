package com.seo.video;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

public class MutipleusersTesting {
    List<String> name = new ArrayList<String>();
    List<String> releaseDate = new ArrayList<String>();
    List<String> category = new ArrayList<String>();
    List<String> rating = new ArrayList<String>();
    List<Integer> id = new ArrayList<>();
    List<Integer> reviewScore = new ArrayList<>();

    @Test
    public void mutipleUsersTest(){

        Response response = given().accept(ContentType.JSON).get("http://localhost:8080/app/videogames")
                            .then().extract().response();
        //validating name from json path
        JsonPath responsejsondata = response.jsonPath();
        id = responsejsondata.get("id");
        System.out.println(id.get(1));
        name =responsejsondata.get("name");
        System.out.println(name.get(1));
        //System.out.println("names are "+name.toString());
        releaseDate = responsejsondata.get("releaseDate");
        System.out.println(releaseDate.get(1));
        //System.out.println("releaseDates are "+releaseDate.toString());
        reviewScore = responsejsondata.get("reviewScore");
        System.out.println(reviewScore.get(1));
        //System.out.println("reviewScores are "+reviewScore.toString());
        category = responsejsondata.get("category");
        System.out.println(category.get(1));
        //System.out.println("categorys are "+category.toString());
        rating = responsejsondata.get("rating");
        System.out.println(rating.get(1));
        //System.out.println("rating are "+rating.toString());
        //how to add assertions for all user names
        assertThat((new Object[]{id.get(1),name.get(1),releaseDate.get(1),reviewScore.get(1),category.get(1),rating.get(1)}),
                  is( new Object[]{2,"Gran Turismo 3","2001-03-10",91,"Driving","Universal"}));




    }

}
