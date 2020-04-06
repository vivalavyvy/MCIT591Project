import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		//Intro text and questions
		System.out.println("Hello! Welcome to movie recommender. \nWe have over 80,000 movies waiting for you. "
				+ "\n\nPlease answer the following questions so that we may give you the correct recommendations.If you"
				+ "feel indefferent towards any of the following questions please enter a 0.");
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println("What genre are you looking for?");
		String genre = userInputScanner.nextLine();
		System.out.println("What year range would you like? \nSelect a number: \n1. 1900-1929 \n2. 1930-1959 \n3. 1960-1979"
				+ "\n4. 1980-1999 \n5. 2000-2019");
		int year = Integer.parseInt(userInputScanner.nextLine());
		System.out.println("In terms of movie rating (from 1-10), above what rating would you like your movie recommendations?");
		double rating = Integer.parseInt(userInputScanner.nextLine());
		System.out.println("Would you like to see any actor or actress in the film? (Please pick and spell a single name correctly)");
		String actors = userInputScanner.nextLine();
		System.out.println("Would you like the film to be directed by a specific person? (Please spell their name correctly)");
		String director = userInputScanner.nextLine();
		System.out.println("How many movies would you like recommended? (We will only show relevant movies)");
		int numberOfMovies = Integer.parseInt(userInputScanner.nextLine());
		System.out.println("Thank you for your input! Gives us a minute...");
		//Comparing the input with the movie database
		Recommender recommend = new Recommender();
		ArrayList<Movie> movieRecommendations = recommend.CompareInput(genre, year, rating, actors, director);
		//Picking five random movies
		movieRecommendations = recommend.RandomPull(numberOfMovies, movieRecommendations);
		//Printing out the recommendations
		for(int i = 0; i < movieRecommendations.size(); i++) {
			System.out.println(i+1 + ". " + movieRecommendations.get(i).getMovieTitle());
		}
	}	
}
