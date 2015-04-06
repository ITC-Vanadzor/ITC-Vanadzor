/**
 * @package com.itcvanadzor.lunch.database
*/

package com.itcvanadzor.lunch.database;

/**
 *@detailed class working with database Orders table
*/
public class Order {
/**
 *@param id id of current order
 *@param placeName place of current order
 *@param placeId unique value for place name 
 *@param productName product name for current order 
 *@param productId unique value for product name 
 *@param count count of products 
 *@param date current date 
 *@param status current status 
*/

    int id;
    String placeName;
    int placeId;
    String productName;
    int productId;
    int count;
    String date;
    String status;

/**
 *@detailed This method gets id, placeName, placeId, productName, productId,
 *count, date and status, and saves it
*/
    public Order (int id, String placeName,int placeId, String productName, int productId, int count, String date, String status) {
      this.id=id;
      this.placeName = placeName;
      this.placeId = placeId;
      this.productName = productName;
      this.productId = productId;
      this.count = count;
      this.date = date;
      this.status = status;
    }
     /**
      *@detailed This method get order id 
      *@return id
      */

    public int getId() {
        return id;
    }

     /**
      *@detailed This method get place name 
      *@return placeName
      */

    public String getPlaceName() {
        return placeName;
    }
    
     /**
      *@detailed This method get place id 
      *@return placeId
      */

    public int getPlaceId() {
        return placeId;
    }

     /**
      *@detailed This method get product name 
      *@return productName
      */

    public String getProductName() {
        return productName;
    }

     /**
      *@detailed This method get product id
      *@return productId
      */

    public int getProductId() {
        return productId;
    }

     /**
      *@detailed This method get product count 
      *@return count
      */

    public int getCount() {
        return count;
    }

     /**
      *@detailed This method get date 
      *@return date
      */

    public String getDate() {
        return date;
    }

     /**
      *@detailed This method get status 
      *@return status
      */

    public String getStatus() {
        return status;
    }
}

