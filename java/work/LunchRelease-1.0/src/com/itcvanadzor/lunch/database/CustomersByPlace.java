/**
 *@package com.itcvanadzor.lunch.database
 */

package com.itcvanadzor.lunch.database;

public class CustomersByPlace {

/**
 *@param loginId  unique value for username
 *@param username name of user, which should be bring order
 */

    String username;
    int loginId;

/**
 *@detailed This method gets productName, count, username and saves it
*/

    public CustomersByPlace (int loginId, String username) {
      this.loginId = loginId;
      this.username = username;
    }

    /**
     *@detailed This method get lodin id
     *@return loginId
     */

    public int getLoginId() {
        return loginId;
    }

    /**
     *@detailed This method get username 
     *@return username
     */

    public String getUsername() {
        return username;
    }
}

