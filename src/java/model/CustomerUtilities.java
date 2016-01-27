
package model;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerUtilities {
    
    Connection conn;
    Statement stmt;
    
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://database.it.kmitl.ac.th/it_29";
            String user = "it_29";
            String pwd = "FPTZJzwd";
            //String sql = "ALTER TABLE Customer CHANGE ID ID int auto_increment;";
            conn = DriverManager.getConnection(url,user,pwd);
            stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insertCus(String Fname,String Lname,String Company,String Mobile,String Email,String Addr){
        String sqlCmd = "insert into Customer (Fname,Lname,Company,Mobile,Email,Address)values('"+Fname + "','"
                                                    + Lname + "','"
                                                    + Company + "','"
                                                    + Mobile + "','"
                                                    + Email + "','"
                                                    + Addr + "')";   
        int numOfRowEffected = 0;
        try{
            numOfRowEffected = stmt.executeUpdate(sqlCmd);
        }catch (SQLException ex){
            Logger.getLogger(CustomerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return numOfRowEffected;
    }
    
    public List<Customer> getCustomer(String sqlCmd){
        List<Customer> result = new LinkedList();
        try{
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()){
                Customer Cus = new Customer();
                Cus.setFname(rs.getString("Fname"));
                Cus.setLname(rs.getString("Lname"));
                Cus.setCompany(rs.getString("Company"));
                Cus.setMobile(rs.getString("Mobile"));
                Cus.setAddr(rs.getString("Address"));
                result.add(Cus);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CustomerUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
