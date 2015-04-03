//package database

public class OrdersByCostumer {

/**
@param productName name of product, which will be bought by username
@param count count of products, which in one place
@param username name of user, which should be bring order
*/

    String productName;
    int count;

/**
@detailed This method gets productName, count, username and saves it
*/

    public OrdersByCostumer (String productName,int count) {
      this.productName = productName;
      this.count = count;
    }
    public String getProductName() {
        return productName;
    }
    public int getCount() {
        return count;
    }
}

