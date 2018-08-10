package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map<String, String>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
        	.flatMap(movieList -> movieList.getVideos().stream()
        			.map(movie -> {
        				Map<String, String> myMap = new HashMap<>();
            			myMap.put("id", movie.getId().toString());
            			myMap.put("title", movie.getTitle());
            			List<BoxArt> boxArt150x200 = movie.getBoxarts().stream()
            				.filter((BoxArt boxArt) -> boxArt.getWidth() == 150 && boxArt.getHeight() == 200)
            				.collect(Collectors.toList());
            			myMap.put("boxart", boxArt150x200.toString());
            			return myMap;
        			}))
        	.collect(toList()); 
    }
}
