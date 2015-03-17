public class Order {
    String placeName;
    int placeId;
    String productName;
    int productId;
    int count;
    String date;
    String status;

    public Order (String placeName,int placeId, String productName, int productId, int count, String date, String status) {
      this.placeName = placeName;
      this.placeId = placeId;
      this.productName = productName;
      this.productId = productId;
      this.count = count;
      this.date = date;
      this.status = status;
    }
}

