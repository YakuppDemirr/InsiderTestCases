package com.insider.method;

import com.insider.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import static com.insider.base.BasePage.*;
import static com.insider.method.CreateMethodPage.*;

public class DeleteMethodPage {

    //Basarili delete istegi
    public static void deletePetMethod() {

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .delete(BasePage.baseUrl + randomNumber)
                .body();

        logger.info("*** Delete methoduna basarili bir sekilde istek atildi. ***");

        String getResponse = response.asString();
        System.out.println("Response Body: " + getResponse);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
