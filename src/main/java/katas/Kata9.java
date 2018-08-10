package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map<String, String>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
        	.flatMap(movies -> movies.getVideos().stream()
        			.map(movie -> {
        				Map<String, String> myMap = new HashMap<>();
            			myMap.put("id", movie.getId().toString());
            			myMap.put("title", movie.getTitle());
            			myMap.put("time", movie.getInterestingMoments().get(1).getTime().toString());
            			Optional<BoxArt> largestBoxart = movie.getBoxarts().stream()
                    			.reduce((BoxArt a, BoxArt b) -> a.getWidth() < b.getWidth() ? a:b);                    		                 		
            			myMap.put("url", largestBoxart.get().toString());
            			return myMap;
        			})
        	).collect(toList());
    }
}
