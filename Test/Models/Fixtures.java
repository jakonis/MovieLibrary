package Models;


public class Fixtures
{
  public static User[] users =
  {
    new User ("Vidas", 40,"Jakonis",  "male" ,"Beast"),
    new User ("Bartek",  20,"Marovisky", "male",   "drama queen"),
    new User ("Kamil", 18,"Bigos" , "male","polish"),
    new User ("Adam",20, "Jonas", "male", "mechanic")
  };

  public static Movie[] movies =
  {
    new Movie ("Ring",  "12/02/2005","http://www.imdb.com/title/tt0298130/"),
    new Movie ("The Shawshank Redemption",  " 14 October 1994","http://www.imdb.com/title/tt0111161/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=0A00MC8HG9NMMKVYWVGS&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_1"),
    new Movie ("The Godfather",   "24 March 1972 ","http://www.imdb.com/title/tt0068646/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=0A00MC8HG9NMMKVYWVGS&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_2"),
    new Movie ("The Godfather: Part II",  " 20 December 1974", "http://www.imdb.com/title/tt0071562/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=0A00MC8HG9NMMKVYWVGS&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_3"),
    new Movie ("The Dark Knight", "18 July 2008","http://www.imdb.com/title/tt0468569/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=0A00MC8HG9NMMKVYWVGS&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_4")
  };

  public static Rating[]Ratings =
  {
    new Rating(222,111,8),
    new Rating(333,222,7),  
    new Rating(444,333,6),
    new Rating(555,444,5)       
  };
}