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
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map<String, String>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
            	.flatMap(movieList -> movieList.getVideos().stream()
            			.map(movie -> {
            				Map<String, String> myMap = new HashMap<>();
                			myMap.put("id", movie.getId().toString());
                			myMap.put("title", movie.getTitle());
                    		Optional<BoxArt> smallestBoxart = movie.getBoxarts().stream()
                    			.reduce((BoxArt a, BoxArt b) -> a.getWidth() < b.getWidth() ? a:b);
                    		
                			myMap.put("boxart", smallestBoxart.get().toString());
                			return myMap;
            			}))
            	.collect(toList()); 
    }
}
