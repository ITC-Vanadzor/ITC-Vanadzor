
/**
@detailed class working with database Orders table
*/
public class Order {
/**
@param placeName place of current order
@param placeId unique value for place name 
@param productName product name for current order 
@param productId unique value for product name 
@param count count of products 
@param date current date 
@param status current status 
*/

    String placeName;
    int placeId;
    String productName;
    int productId;
    int count;
    String date;
    String status;

/**
@detailed This method gets placeName, placeId, productName, productId, count, date and status, and saves it
*/
    public Order (String placeName,int placeId, String productName, int productId, int count, String date, String status) {
      this.placeName = placeName;
      this.placeId = placeId;
      this.productName = productName;
      this.productId = productId;
      this.count = count;
      this.date = date;
      this.status = status;
    }
    public String getPlaceName() {
        return placeName;
    }
    public int getPlaceId() {
        return placeId;
    }
    public String getProductName() {
        return productName;
    }
    public int getProductId() {
        return productId;
    }
    public int getCount() {
        return count;
    }
    public String getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
}

