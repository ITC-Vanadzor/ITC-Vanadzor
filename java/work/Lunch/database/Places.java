
/**
@detailed class working with database Places table
*/

public class Places {

/**
@param id unique value for places
@param placeName name of place
*/
    int placeId;
    String placeName;

/**
@detailed This method gets id nad placeName and saves it
*/
    public Places(int placeId, String placeName) {
      this.placeId = placeId;
      this.placeName = placeName;
    }
    public int getPlaceId() {
        return placeId;
    }
}
