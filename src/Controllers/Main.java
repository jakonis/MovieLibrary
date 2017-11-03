package Controllers;

import java.io.File;

import Models.Movie;
import Utils.Serializer;
import Utils.XMLSerializer;

public class Main
{
  public static void main(String[] args) throws Exception
  {    
    File  datastore = new File("datastore.xml");
    Serializer serializer = new XMLSerializer(datastore);
    
    API API = new API(serializer);
    if (datastore.isFile())
    {
      API.load();
    }
      else
    {
      API.InitialLoad();
    }
    
    API.addUser("Alanas",20,"Jakonis","jakonis@gmail.com","GymFreak" );
    API.addMovie("Ring", "12/02/2005","http://www.imdb.com/title/tt0298130/");
    API.store();
    
    Movie result = API.getMovie(Long.valueOf(1));
    
    System.out.println(result);
    
    
  }
  }
    