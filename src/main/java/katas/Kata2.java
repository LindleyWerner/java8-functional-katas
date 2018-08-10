package katas;

import static java.util.stream.Collectors.toList;

import java.util.List;

import model.Movie;
import util.DataUtil;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
        	.filter(movie -> movie.getRating() == 5.0)
        	.map(movie -> movie.getId())
        	.collect(toList());
    }
}
