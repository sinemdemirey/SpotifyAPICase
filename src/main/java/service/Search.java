package service;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import spec.RequestSpec;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class Search extends RequestSpec {

    public String getArtistID(){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q","Cyndi Lauper")
                        .queryParam("type","artist")
                        .queryParam("limit","3")
                        .when()
                        .get("/search")
                        .then()
                        .extract().response();
        List<Object> a  = ((RestAssuredResponseImpl) response).response().path("artists.items.id");
        String artistId = (String) a.get(0);
        assertNotNull(artistId);
        return artistId;
    }

    public String getArtistName(){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q","Cyndi Lauper")
                        .queryParam("type","artist")
                        .queryParam("limit","3")
                        .when()
                        .get("/search")
                        .then()
                        .extract().response();
        String a  = ((RestAssuredResponseImpl) response).response().path("artists.items.name");
        String a2 = response.getBody().jsonPath().getString("artists.items.name");
        //String artistName = (String) a.get(0);
        System.out.println(a2);
        return a2;
    }
}
