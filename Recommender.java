import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Recommender {
	public ArrayList<Movie> CompareInput(String genre, int year, double rating, String actors, String director) {
		int counter = 1;
		MovieReader mr = new MovieReader();
		HashMap<Integer, Movie> movieData = mr.MovieReader("movie_metadata.csv");
		ArrayList<Movie> finalRecommendations = new ArrayList<Movie>();
		for(int i = 1; i < movieData.size(); i++) {
			//Ensuring genre, rating and (actor or director) criteria is met - if it is empty it stores all
			if((movieData.get(i).getGenre().contains(genre) || genre.contains("0")) && 
					(movieData.get(i).getActors().contains(actors) || actors.contains("0")) ||
					(movieData.get(i).getDirector().contains(director) || director.contains("0")) && 
					(movieData.get(i).getMovieRating() >= rating || !(rating < 10 && rating > 0))) {
				//Ensuring the year range is respected
				if(year == 1 && movieData.get(i).getMovieYear() < 1930) {
					finalRecommendations.add(counter,movieData.get(i));
				}
				else if(year == 2 &&  1929 < movieData.get(i).getMovieYear() && movieData.get(i).getMovieYear() < 1960) {
					finalRecommendations.add(counter,movieData.get(i));
				}
				else if(year == 3 &&  1959 < movieData.get(i).getMovieYear() && movieData.get(i).getMovieYear() < 1980) {
					finalRecommendations.add(counter,movieData.get(i));
				}
				else if(year == 4 &&  1979 < movieData.get(i).getMovieYear() && movieData.get(i).getMovieYear() < 2000) {
					finalRecommendations.add(counter,movieData.get(i));
				}
				else if(year == 5 &&  1999 < movieData.get(i).getMovieYear() && movieData.get(i).getMovieYear() < 2020) {
					finalRecommendations.add(counter,movieData.get(i));
				}
				else if(!(year < 5 && year > 0)){
					finalRecommendations.add(counter,movieData.get(i));
				}
				
			}
		}
		return finalRecommendations;
	}
	
	public ArrayList<Movie> RandomPull(int numberOfMovies, ArrayList<Movie> movieArray) {
		ArrayList<Movie> movies = movieArray;
		ArrayList<Movie> randomFinalMovies = new ArrayList<Movie>();
        Collections.shuffle(movies);
        //Ensuring that there is no out of bounds if the user wants more movies than the array has 
        if(numberOfMovies > movies.size()) {
        	numberOfMovies = movies.size();
        }
        //Pulling the number of movies the user wants
        for(int i = 0; i < numberOfMovies; i++) {
        	randomFinalMovies.add(movies.get(i));
        }
		return randomFinalMovies;
	}
}
