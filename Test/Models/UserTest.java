package Models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import Models.User;

import org.junit.Test;
import static Models.Fixtures.users;


public class UserTest
{
	User alanas = new User ("alanas", 20, "jakonis",  "male"  , "gymFreak");

  @Test
  public void testCreate()
  {
    assertEquals ("alanas",               alanas.firstName);
    assertEquals (20,                     alanas.age);
    assertEquals ("jakonis",              alanas.lastName);   
    assertEquals ("male",                 alanas.gender);  
    assertEquals ("gymFreak",             alanas.occupation);
  }
  
  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (User user : users)
    {
      ids.add(user.id);
    }
    assertEquals (users.length, ids.size());
  }
  
  @Test
  public void testToString()
  {
    assertEquals ("User{" + alanas.id + ", alanas, jakonis, 20, gymFreak, male}", alanas.toString());
   
  }
  
  
  @Test
  public void testEquals()
  {
    User alanas2 = new User ("alanas", 20, "jakonis",  "male"  , "gymFreak"); 
    User Kamil   = new User ("kamil", 18, "bigos", "betaMale", "polish"); 

    assertEquals(alanas, alanas);
    assertEquals(alanas, alanas2);
    assertNotEquals(alanas, Kamil);
  } 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}