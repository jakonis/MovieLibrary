package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Models.Movie;
import Models.Rating;
import Models.User;
import edu.princeton.cs.introcs.In;



public class CSVLoader {

	public List<User> loadUsers(String filename) throws Exception {

		File usersFile = new File(filename);

		In inUsers = new In(usersFile);

		String delims = "[|]";

		List<User> users = new ArrayList<User>();

		while (!inUsers.isEmpty()) {

			String userDetails = inUsers.readLine();

			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {

				String firstName = userTokens[1];

				String lastName = userTokens[2];

				int age = Integer.valueOf(userTokens[3]);

				String gender = userTokens[4];

				String occupation = userTokens[6];

				users.add(new User (firstName, age, lastName, gender, occupation));

			} else {

				throw new Exception("Invalid member length: " + userTokens.length);

			}

		}

		return users;

	}



	public List<Movie> loadMovies(String filename) throws Exception {
	
		File moviesFile = new File(filename);

		In inmovies = new In(moviesFile);

		String delims = "[|]";

		List<Movie> movies = new ArrayList<Movie>();

		while (!inmovies.isEmpty()) {

			String movieDetails = inmovies.readLine();

			String[] movieTokens = movieDetails.split(delims);

			if (movieTokens.length == 23) {

				String title = movieTokens[1];

				String releasedate = movieTokens[2];

				String url = movieTokens[3];


				movies.add(new Movie (title, releasedate, url));

			} else {

				throw new Exception("Invalid member length: " + movieTokens.length);

			}

		}

		return movies;

	}

	



	public List<Rating> loadRatings(String filename) throws Exception {

		File RatingsFile = new File(filename);

		In inRatings = new In(RatingsFile);

		String delims = "[|]";

		List<Rating> Ratings = new ArrayList<Rating>();

		while (!inRatings.isEmpty()) {

			String RatingDetails = inRatings.readLine();

			String[]RatingTokens = RatingDetails.split(delims);

			if (RatingTokens.length == 4) {

			      long userID =Long.valueOf(RatingTokens[1]);

				  long movieID = Long.valueOf(RatingTokens[2]);

				  int rating = Integer.valueOf(RatingTokens[3]);


				Ratings.add(new Rating (userID , movieID , rating));

			} else {

				throw new Exception("Invalid member length: " + RatingTokens.length);

			}

		}

		return Ratings;
	
	}

}