package Controllers;



import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Optional;

import Models.Movie;
import Models.Rating;
import Models.User;
import Utils.CSVLoader;
import Utils.Serializer;

public class API {
	
	private Map<Long,   User>   userIndex       = new HashMap<>();
	private Map<Long,   Movie>   MovieIndex       = new HashMap<>();
	private Map<Long,   Rating>   RatingIndex       = new HashMap<>();
	private Serializer serializer;

	public API()
	  {}
	
		
	  public API(Serializer serializer)
	  {
	    this.serializer = serializer;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public void load() throws Exception
	  {
	    serializer.read();
	    userIndex       = (Map<Long, User>) serializer.pop();
	    MovieIndex      = (Map<Long, Movie>)   serializer.pop();
	    RatingIndex     = (Map<Long, Rating>)     serializer.pop();
	  }
	  
	  void store() throws Exception
	  {
	    serializer.push(User.counter);
	    serializer.push(Movie.counter);
	    serializer.push(Rating.counter);
	    serializer.write(); 
	  }
	
	
	  public Collection<User> getUsers ()
	  {
	    return userIndex.values();
	  }
	  
	  public User addUser(String firstName, int age, String lastName,String gender,String occupation)
	  {
	    User user = new User (firstName, age,lastName, gender, occupation);
	    userIndex.put(user.id, user);
	    return user;
	  
	  }
	  
	  public  void deleteUsers() 
	  {
	    userIndex.clear();
	  }
	  
	  public Movie addMovie(String title, String releasedate, String url)
	  {
	    Movie movie = new Movie (title,releasedate,url);
	    MovieIndex.put(movie.id, movie);
	    return movie;
	  }
	  
	  public Rating addRating(long userID,long movieID,int rating)
	  {
		    Rating ratings = null;
		    Optional<User> user = Optional.fromNullable(userIndex.get(userID));
		    if (user.isPresent())
		    {
		      ratings = new Rating (userID, movieID, rating);
		      user.get().UserRating.put(ratings.userID, ratings);
		      RatingIndex.put(ratings.userID, ratings);
		    }
		    return ratings;
		  }
		   
	  
	  
	  public Movie getMovie(Long movieid) 
	  {
	    return MovieIndex.get(movieid);
	  }
	  
	  public Rating getUserRatings(long userID) 
	  {
	    return RatingIndex.get(userID);
	  }
	  
	  
	 public Movie getMovieByTitle(String title) 
	 {
	   
		 return MovieIndex.get(title);
	
	  }
	 
	 public Movie getMovieByYear(int year) 
	 {
	   
		 return MovieIndex.get(year);
	
	  }
	 
	 public void InitialLoad() throws Exception
	 {
	 CSVLoader loader = new CSVLoader();
	 List <User> usersdata = loader.loadUsers("moviedata_small/users5.dat");
	 for(User user: usersdata)
	 {
	 userIndex .put(user.id,user);
	 }
	 List <Movie> moviedata = loader.loadMovies("moviedata_small/items5.dat");
	 for(Movie movie:  moviedata )
	 {
	 MovieIndex.put(movie.id, movie);
	 }
	 List <Rating> ratingdata = loader.loadRatings("moviedata_small/ratings5.dat");
	 for(Rating rating:  ratingdata )
	 {
	 RatingIndex.put(rating.userID, rating);
	 }
	 }
	 
}
