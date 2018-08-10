package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codepoetics.protonpack.StreamUtils;

import model.Bookmark;
import model.Movie;
import util.DataUtil;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map<String, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();
        
        return StreamUtils.zip(
        		movies.stream(), 
        		bookMarks.stream(), 
        		(movie, bookMark) -> {
        			Map<String, String> myMap = new HashMap<>();
        			myMap.put("videoId", movie.getId().toString());
        			myMap.put("bookmarkId", bookMark.getId().toString());
        			return myMap;
        		})
        	.collect(toList());
    }
}
