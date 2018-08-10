package katas;

import java.util.List;
import java.util.Optional;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        Optional<BoxArt> largestBoxartMovie = movies.stream()
        	.map(movie -> {        	
        		Optional<BoxArt> largestBoxart = movie.getBoxarts().stream()
        			.reduce((BoxArt a, BoxArt b) -> a.getWidth() < b.getWidth() ? b:a);
        		if(largestBoxart.isPresent()) {
        			return largestBoxart.get();
        		}
        		return null;
        	})        	
        	.reduce((BoxArt a, BoxArt b) -> a.getWidth() < b.getWidth() ? b:a);
        
        if(largestBoxartMovie.isPresent()) {
        	return largestBoxartMovie.get().getUrl();
        }
        return null;
    }
}
