package service;

import io.restassured.response.Response;
import spec.RequestSpec;

import static io.restassured.RestAssured.given;

public class Artists extends RequestSpec {
    public void getArtistsTopTracks(String artistID){
        Response response =
                given()
                    .spec(super.getRequestSpecification())
                        .queryParam("market", "us")
                        .when()
                        .get("/artists/{id}/top-tracks", artistID)
                        .then()
                        .extract().response();
        response.prettyPrint();
    }
}
