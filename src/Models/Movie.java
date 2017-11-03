package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Movie 
{
  public static Long   counter = 0l;

  public Long   id;
  public String title;
  public String releasedate;
  public String url;
 
  
  public Map<Long, Movie> Movies = new HashMap<>();
  
  public Movie()
  {
  }
  
  public Movie(String title, String releasedate, String url)
  {
    this.id        = counter++;
    this.title = title;
    this.releasedate = releasedate;
    this.url = url;
  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(id)
    		                   .addValue(title)
                               .addValue(releasedate)
                               .addValue(url)                             
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.title, this.releasedate, this.url);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Movie)
    {
      final Movie other = (Movie) obj;
      return Objects.equal(id, other.id) 
          && Objects.equal(title,  other.title)
          && Objects.equal(releasedate,     other.releasedate)
          && Objects.equal(url,  other.url);
    }
    else
    {
      return false;
    }
  }
}
