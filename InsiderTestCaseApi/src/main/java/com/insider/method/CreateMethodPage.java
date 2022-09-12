package com.insider.method;

import com.insider.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Random;
import static com.insider.base.BasePage.*;

public class CreateMethodPage {

    public static Random random;
    public static Integer randomNumber;

    //Basarili post istegi
    public static void postPetMethod()
    {
        random = new Random();
        randomNumber = random.nextInt(100000);

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randomNumber);
        jsonPet.put("name", "Test Name" + " " + randomNumber);
        jsonPet.put("status", "available");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Deneme Photo Url");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randomNumber);
        jsonCategory.put("name", "Category Test Name" + " " + randomNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randomNumber);
        jsonTags.put("name", "Tags Test Name" + " " + randomNumber);

        ArrayList tags = new ArrayList();
        tags.add(jsonTags);

        jsonPet.put("category", jsonCategory);
        jsonPet.put("tags", tags);
        jsonPet.put("photoUrls", jsonArray);

        logger.info("*** Post methodu icin tüm parametreler girildi. ***");
        String json = jsonPet.toString();

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = (Response) requestSpecification
                .given()
                .baseUri(BasePage.baseUrl)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().body();

        logger.info("*** Post methoduna basarili bir sekilde istek atildi. ***");
        String postResponse = response.asString();
        System.out.println(postResponse);
    }

    //Status Code 405 Method Not Allowed
    public static void postPetMethodNegativeCase()
    {
        random = new Random();
        randomNumber = random.nextInt(100000);

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randomNumber);
        jsonPet.put("name", "Test Name" + " " + randomNumber);
        jsonPet.put("status", "available");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Deneme Photo Url");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randomNumber);
        jsonCategory.put("name", "Category Test Name" + " " + randomNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randomNumber);
        jsonTags.put("name", "Tags Test Name" + " " + randomNumber);

        ArrayList tags = new ArrayList();
        tags.add(jsonTags);

        jsonPet.put("category", jsonCategory);
        jsonPet.put("tags", tags);
        jsonPet.put("photoUrls", jsonArray);

        String json = jsonPet.toString();
        logger.info("*** Post methodu icin tüm parametreler girildi. ***");

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = (Response) requestSpecification
                .given()
                .baseUri(BasePage.baseUrl)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(405)
                .extract().response().body();

        String postResponse = response.asString();
        System.out.println(postResponse);
    }
}
