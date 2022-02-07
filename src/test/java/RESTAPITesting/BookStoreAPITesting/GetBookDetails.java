package RESTAPITesting.BookStoreAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import jdk.internal.org.objectweb.asm.TypeReference;
import org.testng.annotations.Test;

import java.util.*;

public class GetBookDetails {

    @Test
    public void getMultipleBookDetails() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/Books");
        System.out.println(response.getBody().prettyPrint());
        JsonPath jsonpath = new JsonPath(response.getBody().asString());
        System.out.println("books list is " + jsonpath.getList("books"));
        System.out.println("isbn value is "+jsonpath.get("books.isbn"));
        List<Integer> isbnList = new ArrayList<Integer>();
        isbnList = jsonpath.get("books.isbn");
        Collections.sort(isbnList,Collections.reverseOrder());
        System.out.println("sorted isbn list is "+isbnList);
        List<Object> BooksList = new ArrayList<Object>();

    }

}
