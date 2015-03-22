/**
@detailed class working with database Distributorss table
*/

public class Distributors {

/**
@param name username
@param nameId unique value for name
@param placeName name of place
@param placeId unique value for placeName
*/

    String name;
    int nameId;
    String placeName;
    int  placeId;

/**
@detailed This method gets name, nameId, placeName, placeId and saves it
*/

    public Distributors (String name, int nameId,String placeName, int placeId) {
        this.name=name;
        this.nameId=nameId;
        this.placeName=placeName;
        this.placeId=placeId;
    }
}
