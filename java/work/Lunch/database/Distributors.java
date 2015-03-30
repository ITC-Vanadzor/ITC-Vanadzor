//package database

/**
@detailed class working with database Distributorss table
*/

public class Distributors {

/**
@param email user email
@param nameId unique value for name
@param placeName name of place
@param placeId unique value for placeName
*/

    String email;
    int emailId;
    String placeName;
    int  placeId;

/**
@detailed This method gets name, nameId, placeName, placeId and saves it
*/

    public Distributors (String email, int nameId,String placeName, int placeId) {
        this.email=email;
        this.emailId=emailId;
        this.placeName=placeName;
        this.placeId=placeId;
    }
    public String getEmail() {
        return this.email;
    }
    public int getEmailId() {
        return this.emailId;
    }
    public String getPlaceName() {
        return this.placeName;
    }
    public int getPlaceId() {
        return this.placeId;
    }
}
