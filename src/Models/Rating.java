package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Rating
{
  public static Long   counter = 0l;

  public Long   id;
  public long userID;
  public long movieID;
  public int rating;

 
  
  public Map<Long, Rating> Rating= new HashMap<>();
  
  public Rating()
  {
  }
  
  public Rating(long userID,long movieID,int rating)
  {
    this.id        = counter++;
    this.userID = userID;
    this.movieID = movieID;
    this.rating = rating;
   
  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(id)
    		                   .addValue(userID)
                               .addValue(movieID)
                               .addValue(rating)
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.userID, this.movieID, this.rating);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Rating)
    {
      final Rating other = (Rating) obj;
      return Objects.equal(id, other.id) 
          && Objects.equal(userID,  other.userID)
          && Objects.equal(movieID,     other.movieID)
          && Objects.equal(rating,  other.rating);
    }
    else
    {
      return false;
    }
  }
}


