package katas;

import static java.util.stream.Collectors.toList;

import java.util.List;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
        	.map(movieList -> movieList.getVideos())
        	.flatMap(movies -> movies.stream()
        			.map(movie -> movie.getId())        			)
        	.collect(toList());
    }
}
