package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User
{
  public static Long   counter = 0l;

  public Long   id;
  public String firstName;
  public String lastName;
  public int age;
  public String gender;
  public String occupation;
 
  
  public Map<Long, Rating> UserRating = new HashMap<>();
  
  public User()
  {
  }
  
  public User(String firstName, int age, String lastName,String gender,String occupation)
  {
    this.id        = counter++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(id)
    		                   .addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)
                               .addValue(occupation)
                               .addValue(gender)
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.firstName, this.lastName, this.age,this.gender,this.occupation);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof User)
    {
      final User other = (User) obj;
      return Objects.equal(id, other.id) 
          && Objects.equal(firstName,  other.firstName)
          && Objects.equal(lastName,     other.lastName)
          && Objects.equal(age,  other.age)
          && Objects.equal(gender,  other.gender)
          && Objects.equal(occupation,  other.occupation);
    }
    else
    {
      return false;
    }
  }
}


