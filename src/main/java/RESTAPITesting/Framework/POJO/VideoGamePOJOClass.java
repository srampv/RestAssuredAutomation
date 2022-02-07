package RESTAPITesting.Framework.POJO;


import com.google.gson.Gson;

import java.util.Map;

public class VideoGamePOJOClass {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private String name;
    private String releaseDate;
    private int reviewScore;
    private String category;
    private String rating;
    Gson gson = new Gson();


    public String getVideoGamePayload(Map<String,String> testData){
        VideoGamePOJOClass videogamepojo = new VideoGamePOJOClass();
        videogamepojo.setId(Integer.parseInt(testData.get("id")));
        videogamepojo.setName(testData.get("name"));
        videogamepojo.setReleaseDate(testData.get("releaseDate"));
        videogamepojo.setReviewScore(Integer.parseInt(testData.get("reviewScore")));
        videogamepojo.setRating(testData.get("rating"));

        return  gson.toJson(videogamepojo);

    }

}
