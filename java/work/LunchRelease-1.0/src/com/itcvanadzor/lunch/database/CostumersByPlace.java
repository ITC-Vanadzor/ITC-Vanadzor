package com.itcvanadzor.lunch.database;

public class CostumersByPlace {

/**
@param productName name of product, which will be bought by username
@param count count of products, which in one place
@param username name of user, which should be bring order
*/

    String username;
    int loginId;

/**
@detailed This method gets productName, count, username and saves it
*/

    public CostumersByPlace (int loginId, String username) {
      this.loginId = loginId;
      this.username = username;
    }
    public int getLoginId() {
        return loginId;
    }
    public String getUsername() {
        return username;
    }
}

