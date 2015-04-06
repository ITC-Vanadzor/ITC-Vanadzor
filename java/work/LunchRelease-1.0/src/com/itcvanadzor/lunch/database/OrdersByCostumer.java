/**
 *@package com.itcvanadzor.lunch.database
 */

package com.itcvanadzor.lunch.database;

public class OrdersByCostumer {

/**
 *@param productName name of product, which will be bought by username
 *@param count count of products, which in one place
*/

    String productName;
    int count;

/**
 *@detailed This method gets productName, count, username and saves it
*/

    public OrdersByCostumer (String productName,int count) {
      this.productName = productName;
      this.count = count;
    }

    /**
     *@detailed This method get product name 
     *@return productName
     */

    public String getProductName() {
        return productName;
    }

    /**
     *@detailed This method get product count
     *@return count
     */
    public int getCount() {
        return count;
    }
}

