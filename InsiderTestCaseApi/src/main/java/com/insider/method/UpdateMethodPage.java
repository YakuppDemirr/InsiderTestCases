package com.insider.method;

import com.insider.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static com.insider.base.BasePage.logger;
import static com.insider.method.CreateMethodPage.*;

public class UpdateMethodPage {

    //Basarili put istegi
    public static void putPetMethod() {

        JSONObject jsonPet = new JSONObject();
        jsonPet.put("id", randomNumber);
        jsonPet.put("name", "Update Test Name" + " " + randomNumber);
        jsonPet.put("status", "pending");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Deneme Photo Url Update");

        JSONObject jsonCategory = new JSONObject();
        jsonCategory.put("id", randomNumber + 2);
        jsonCategory.put("name", "Category Test Name" + " " + randomNumber);

        JSONObject jsonTags = new JSONObject();
        jsonTags.put("id", randomNumber + 1);
        jsonTags.put("name", "Tags Test Name" + " " + randomNumber);

        ArrayList tags = new ArrayList();
        tags.add(jsonTags);

        jsonPet.put("category", jsonCategory);
        jsonPet.put("tags", tags);
        jsonPet.put("photoUrls", jsonArray);

        logger.info("*** Put methodu icin update edilecek parametreler girildi. ***");
        String json = jsonPet.toString();

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = (Response) requestSpecification
                .given()
                .baseUri(BasePage.baseUrl)
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().body();

        logger.info("*** Put methoduna basarili bir sekilde istek atildi. ***");
        String postResponse = response.asString();
        System.out.println(postResponse);
    }
}
