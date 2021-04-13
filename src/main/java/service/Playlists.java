package service;

import core.BaseFunctions;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Playlists extends RequestSpec {

    public String createPlaylist(String userId, String description, String publicValue) throws IOException {
        JSONObject json = BaseFunctions.readJsonFile("playlist");
        json.put("name", "Cyndi Lauper");
        json.put("description", description);
        json.put("public", publicValue);

        Response response =
                given()
                    .spec(super.getRequestSpecification())
                        .body(json.toString())
                .when()
                    .post("/users/{user_id}/playlists", userId)
                .then()
                    .extract().response();
        assertThat("Status code is not 200", response.statusCode(), equalTo(201));
        System.out.println(response.getBody().jsonPath().getString("id"));
        return response.getBody().jsonPath().getString("id");
    }



    public void changePlaylistsDetail() throws IOException {
        JSONObject json = BaseFunctions.readJsonFile("playlist.json");
        json.put("name", "new test title");
        json.put("description", "description");
        json.put("public", "publicValue");

        Response response =
                given()
                    .spec(super.getRequestSpecification())
                    .body(json.toString())
                .when()
                    .put("/playlists/{playlist_id}", "6gtZvInXmbbKNFQhDe0KaM")
                .then()
                        .spec(ResponseSpec.checkStatusCode(200))
                    .extract().response();

        assertThat("Status code is not 200", response.statusCode(), equalTo(200));

    }

    public void addItemsToPlayList(String playlistID){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        //.body(json.toString())
                        .when()
                        .post("/playlists/{playlist_id}/tracks", playlistID)
                        .then()
                        .spec(ResponseSpec.checkStatusCode(200))
                        .extract().response();

        assertThat("Status code is not 200", response.statusCode(), equalTo(200));
    }
}
