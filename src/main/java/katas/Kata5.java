package katas;

import java.util.List;
import java.util.Optional;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        Optional<Movie> maxRatingMovie = movies.stream()
        	.reduce((Movie a, Movie b) -> a.getRating() < b.getRating() ? b:a);
        
        if(maxRatingMovie.isPresent()) {
        	return maxRatingMovie.get().getRating();
        }
        return null;
    }
}
