
package customerdb_test;

import model.CustomerUtilities;

public class CustomerDB_TEST {

    public static void main(String[] args) {
        
        CustomerUtilities Customer = new CustomerUtilities();
        Customer.init();
        int numOfRowEffected = Customer.insertCus("beer", "beer","it","0800743662","beer@@@","Thailand");
        
        if (numOfRowEffected == 1){
            System.out.println("Insert Successfully!!!");
        }
    }
    
}
