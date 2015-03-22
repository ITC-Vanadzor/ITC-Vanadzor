/**
@detailed class working with database Places table
*/

public class Places {

/**
@param id unique value for places
@param placeName name of place
*/
    int id;
    String placeName;

/**
@detailed This method gets id nad placeName and saves it
*/
    public Places(int id, String placeName) {
      this.id = id;
      this.placeName = placeName;
    }
}
