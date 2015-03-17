public class Products {
    String productName;
    int  productId;
    int count;

    public Products (String productName, int productId) {
        this.productName=productName;
        this.productId=productId;
    }
    public Products(String productName, int productId, int count) {
        this.productName = productName;
        this.productId = productId;
        this.count = count;
    }

}
