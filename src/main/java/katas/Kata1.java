package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Movie;
import util.DataUtil;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map<String, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        return movies.stream()
        		.map(movie -> {
        			Map<String, String> myMap = new HashMap<>();
        			myMap.put("id", movie.getId().toString());
        			myMap.put("title", movie.getTitle());
        			return myMap;
        		})
        		.collect(toList());        
    }
}
