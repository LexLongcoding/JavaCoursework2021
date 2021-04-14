import java.util.*;
//Create a trackList of type HashMap
// Add in at least 4 songs that are stored by title
//Pull out one of the songs by its track title
//Print out all the track names and lyrics in the format Track: Lyrics    


public class Hashmat {
    public void Display() {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Song 1", "Lyrics to song 1");
        tracklist.put("Song 2", "Lyrics to song 2");
        tracklist.put("Song 3", "Lyrics to song 3");
        tracklist.put("Song 4", "Lyrics to song 4");

        System.out.println(tracklist.get("Song 2"));
        for (String key : tracklist.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, tracklist.get(key)));
        }
        


    }
}