/**
 *@package com.itcvanadzor.lunch.database
 */

package com.itcvanadzor.lunch.database;

/**
 *@detailed class working with database Distributorss table
 */

public class Distributors {

/**
 *@param username username
 *@param loginId unique value for name
 *@param placeName name of place
 *@param placeId unique value for placeName
 */

    String email;
    int emailId;
    String placeName;
    int  placeId;

/**
 *@detailed This method gets name, nameId, placeName, placeId and saves it
 */

    public Distributors (String email, int emailId, String placeName, int placeId) {
        this.email = email;
        this.emailId = emailId;
        this.placeName=placeName;
        this.placeId=placeId;
    }

    /**
     *@detailed This method get username 
     *@return username
     */

    public String getEmail() {
        return this.email;
    }

    /**
     *@detailed This method get login id 
     *@return loginId
     */

    public int getEmailId() {
        return this.emailId;
    }

    /**
     *@detailed This method get place name 
     *@return placeName
     */

    public String getPlaceName() {
        return this.placeName;
    }

    /**
     *@detailed This method get place id 
     *@return placeId
     */

    public int getPlaceId() {
        return this.placeId;
    }
}
