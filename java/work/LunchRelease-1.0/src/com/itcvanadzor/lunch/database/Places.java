/**
 * @package com.itcvanadzor.lunch.database
 */

package com.itcvanadzor.lunch.database;

/**
 *@detailed class working with database Places table
 */

public class Places {

/**
 *@param id unique value for places
 *@param placeName name of place
 */
    int placeId;
    String placeName;

/**
 *@detailed This method gets id nad placeName and saves it
 */
    public Places(int placeId, String placeName) {
      this.placeId = placeId;
      this.placeName = placeName;
    } 

    /**
     *@detailed This method get place id
     *@return placeId
     */

    public int getPlaceId() {
        return placeId;
    }

    /**
     *@detailed This method get place name 
     *@return placeName
     */

    public String getPlaceName() {
        return placeName;
    }
}
