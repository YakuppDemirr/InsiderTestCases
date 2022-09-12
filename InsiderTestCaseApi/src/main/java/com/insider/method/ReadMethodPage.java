package com.insider.method;

import com.insider.base.BasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static com.insider.base.BasePage.*;
import static com.insider.method.CreateMethodPage.*;
import static io.restassured.RestAssured.given;

public class ReadMethodPage {

    //Basarili get istegi
    public static void getPetMethod() {

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrl + randomNumber)
                .body();

        logger.info("*** Get methoduna basarili bir sekilde istek atildi. ***");

        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrl + randomNumber)
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 200);
    }

    //Id:integer ama parametre olarak string girildi.
    public static void getPetMethodNegativeBadReq() {

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrl + "String Text")
                .body();


        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BasePage.baseUrl + "String Text")
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 400);
    }

    //Method Not Allowed Status Code 405
    public static void getPetMethodNegativeNotAllowed() {

        RequestSpecification requestSpecification = RestAssured.given();

        Response response = (Response) requestSpecification
                .contentType(ContentType.JSON)
                .when()
                .post(BasePage.baseUrl + 123)
                .body();

        int getStatusCodeSubject = given()
                .contentType(ContentType.JSON)
                .when()
                .post(BasePage.baseUrl + 123)
                .getStatusCode();

        String getResponse = response.asString();
        System.out.println(getResponse);

        System.out.println("Response Code: " + getStatusCodeSubject);
        Assert.assertEquals(getStatusCodeSubject, 405);
    }
}
