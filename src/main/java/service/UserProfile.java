package service;

import io.restassured.response.Response;
import spec.RequestSpec;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class UserProfile extends RequestSpec {

    public String getCurrentUser(){
        Response response =
                given()
                    .spec(super.getRequestSpecification())
                .when()
                    .get("/me")
                .then()
                    .extract().response();
        String userID = response.getBody().jsonPath().getString("id");
        //response.getBody().jsonPath().prettyPrint();
        assertNotNull(userID);
        return userID;
    }

    public void getUserByUserId(){
        Response response =
                given()
                    .spec(super.getRequestSpecification())
                .when()
                    .get("/users/{user_id}", getCurrentUser())
                .then()
                    .extract().response();
        //response.getBody().jsonPath().prettyPrint();
    }
}
