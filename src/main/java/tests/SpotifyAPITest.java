package tests;

import org.testng.annotations.Test;
import service.Artists;
import service.Playlists;
import service.Search;
import service.UserProfile;
import spec.RequestSpec;

import java.io.IOException;

public class SpotifyAPITest extends RequestSpec {
    /** TEST CASE IS:
     * 1. Create a user profile.
     * 2. Get its userID.
     * 3. 
     * 4.
     * */

    @Test
    public void testAPICase() throws IOException {
        UserProfile userProfile = new UserProfile();
        Playlists playlists = new Playlists();
        Search search = new Search();
        Artists artists = new Artists();
        search.getArtistID();
        artists.getArtistsTopTracks(search.getArtistID());
        userProfile.getCurrentUser();
        playlists.createPlaylist(userProfile.getCurrentUser(),"oldu mu","true");
        //search.getArtistName();
    }
}
