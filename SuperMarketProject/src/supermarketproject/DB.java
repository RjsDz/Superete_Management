
package supermarketproject;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;
/**
 *
 * @author RJS
 */


public class DB {
  public static String DB_NAME = "super_market";
  public static String HOST = TextFileDBConfig.getHost();                 //127.0.0.1";
  public static int PORT = Integer.parseInt(TextFileDBConfig.getPort());
  public static String PASS = "";
 
  
  public static Connection getConnection(){
      Connection con = null;
      try {
          con = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME,"root","");
      } catch (SQLException ex) {
         System.out.println(ex+"");
      }
      
      return con;
  }
 // @USERS  
  public static boolean isUserExist(String password,String username) {
    Connection con = null;
    try {
        String sql = "SELECT password FROM users WHERE username = ?";
        con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // If there is a matching user, return the stored password
            return rs.getString("password").equals(password);
        } else {
            // No matching user found
            return false;
        }

    } catch (SQLException ex) {
        System.out.println(ex);
        return false; // Handle the exception appropriately in your application
    } finally {
        // Close the resources (Connection, PreparedStatement, ResultSet)
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}



    private static boolean isPasswordMatch(String enteredPassword, String storedPassword) {
        // Implement your password hashing and comparison logic here
        // Example: return enteredPassword.equals(storedPassword);
        return enteredPassword.equals(storedPassword); // Replace with actual password hashing
    }
  
  
  public static void insertUser(String userName,String pass){
      Connection con;
      try{
          con = getConnection();
          String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
          PreparedStatement ps;
          ps = con.prepareStatement(sql);
          ps.setString(1, userName);
          ps.setString(2,pass);
          ps.executeUpdate();
         // ps.close();
          con.close();
      }catch(Exception e){
          e.getStackTrace();
          System.out.println(e+"");
      }
  }
  
    public static void updateUsersPass(String pass){
        Connection con;
      try{
          con = (Connection)getConnection();
          String sql = "UPDATE users SET password=? WHERE password = ?";
          PreparedStatement ps;
          ps = con.prepareStatement(sql);
          ps.setString(1, pass);
          ps.setString(2,pass);
          ps.executeUpdate();
          
          con.close();
      }catch(Exception e){
         System.out.println(e+"");
      }
  }
    
    public static void deleteUser(String username){
        String sql = "DELETE FROM users WHERE username=?";
        Connection con = null;
        try{
            con = (Connection)getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e+"");
        }
    }
  
  
//@Products 
  public static void insertProduct(String productName, String codeBar, float price){
      productName = productName.toUpperCase();
      Connection con;
      try {
          
          String sqlQuery = "INSERT INTO products (product_name, code_bar, price) VALUES (?, ?, ?)";
          
          con = (Connection) getConnection();
           
          PreparedStatement ps = con.prepareStatement(sqlQuery);
          
           ps.setString(1,productName.toUpperCase());
           ps.setString(2, codeBar);
           ps.setFloat(3, price);
           ps.executeUpdate();
           ps.close();
           con.close();
           
      } catch (Exception ex) {
          ex.setStackTrace(null);
      }
  }
  
  public static void ubdateProduct(String codeBar, String productName, float price){
      Connection con = (Connection) getConnection();
      try{
         
          con = getConnection();
          String sql =  "UPDATE products SET product_name = ?, price = ? WHERE code_bar = ?";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1,productName.toUpperCase());
          ps.setFloat(2,price);
          ps.setString(3, codeBar);
          ps.executeUpdate();
          ps.close();
          con.close();
      }catch(Exception e){
          e.getStackTrace();
      }
  }
  
   public static void deleteProduct(String codeBar){
       Connection con;
       try{
         con = (Connection)getConnection();
         String sql = "DELETE FROM products WHERE code_bar = ?";
         PreparedStatement ps;
         ps = con.prepareStatement(sql);
         ps.setString(1, codeBar);
         ps.executeUpdate();
         ps.close();
         con.close();
       }catch(Exception e){
           e.getStackTrace();
       }
   }
   
   
   public static boolean productFound(String codeBare){
       
       Connection con = null;
       try{
           con = getConnection();
           String sql = "SELECT * FROM products WHERE code_bar = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, codeBare);
           ResultSet rs  = ps.executeQuery();
           return rs.next();
        
       }catch(Exception ex){
           System.out.println(ex+"");
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e + "");
           }
      }
       
       
       return false;
   }
   
public static void updatePassword(String curP, String newP) {
    Connection con = null;
    String sql = "UPDATE users SET password=? WHERE password=?";

    try {
        con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newP);
        ps.setString(2, curP);
        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Your password is updated successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Your old password is incorrect.");
        }

        con.close();
    } catch (Exception ex) {
        System.out.println(ex);
        ex.printStackTrace(); // Print the stack trace for debugging
        JOptionPane.showMessageDialog(null, "Error updating password. Please try again.");
    }
}

   
   
   public static void addSale(String username,String product,String codeBar,float price,float qte,float sum,String date,String time){
       Connection con;
       
       try{
           con = getConnection();
           PreparedStatement ps;
           String sql = "INSERT INTO sales (username,product, code_bar, price, qte , sum, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           ps = con.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, product);
           ps.setString(3, codeBar);
           ps.setFloat(4,price);
           ps.setFloat(5, qte);
           ps.setFloat(6, sum);
           ps.setString(7, date);
           ps.setString(8, time);
           ps.executeUpdate();
           con.close();
           
           
       }catch(Exception ex){
           System.out.println(ex+"");
       }
       
   }
   
   
   public static float fechPriceByCodeBare(String codeBar){
       Connection con = null;
       float price = -1; // if it's not exists
       
       try{
           con = getConnection();
           String sql = "SELECT price FROM products WHERE code_bar = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,codeBar);
           ResultSet rs = ps.executeQuery();
           price = rs.getFloat("price");
           return price;
       }catch(Exception ex){
           System.out.println(ex+"");
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e + "");
           }
      }
       return price;
   }
  
  
      public static float fechPriceByProductName(String product){
       Connection con = null;
       float price = -1; // if it's not exists
       
       
       try{
           con = getConnection();
           String sql = "SELECT price FROM products WHERE price = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,product);
           ResultSet rs = ps.executeQuery();
           price = rs.getFloat("price");
           return price;
       }catch(Exception ex){
           System.out.println(ex+"");
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e + "");
           }
      }
       return price;
   }
  
    public static String fechProducNameByCodeBare(String codeBare){
       Connection con = null;
       String product = "Product Not Fount"; // if it's not exists
       
       
       try{
           con = getConnection();
           String sql = "SELECT product FROM products WHERE code_bar = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,codeBare);
           ResultSet rs = ps.executeQuery();
           product = rs.getString("product");
           con.close();
           return product;
       }catch(Exception ex){
           System.out.println(ex+"");
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e + "");
           }
      }
       return product;
   }
    
    
public static boolean isAdmin(String username, String password) {
    Connection con = null;
    try {
        String sql = "SELECT * FROM users";
        con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int rootValue = rs.getInt("root");
            String dbUsername = rs.getString("username");
            String dbPassword = rs.getString("password");

            System.out.println("Root Value: " + rootValue);
            System.out.println("DB Username: " + dbUsername);
            System.out.println("DB Password: " + dbPassword);

            if (rootValue == 1 && dbUsername.trim().equals(username.trim()) && dbPassword.trim().equals(password.trim())) {
                return true;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    return false;
}

    public static ObservableList <Products> fetchAllProducts(){
        Connection con = null;
        ObservableList <Products> list = FXCollections.observableArrayList();
        
        try{
            con = getConnection();
            String sql = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               list.add(new Products(rs.getInt("id"),rs.getString("product_name"),rs.getString("code_bar"),rs.getFloat("price")));
               
            }
            
        }catch(Exception ex){
            System.out.println(ex+"");
        }
        return list;
    }

    public static int isAdmin(String username){
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT root FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                return rs.getInt("root");
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "ther is not such this name in database !!!!");
            System.out.println(ex+"");
            return -1;
        }
        return -1;
    }
    
    public static void addAdmin(String username){
        Connection con = null;
        try{
            con = getConnection();
            String sql = "UPDATE users SET root = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,1 );
            ps.setString(2, username);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "the proceec is successfully .");
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "ther is not such this name in database !!!!");
            
            System.out.println(ex+"");
            
        }
    }
    
    
    public static void addNotAddmin(String username){
        Connection con = null;
        try{
            con = getConnection();
            String sql = "UPDATE users SET root = ? WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,0 );
            ps.setString(2, username);
            ps.executeUpdate();
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "ther is not such this name in database !!!!");
            
            System.out.println(ex+"");
            
        }
    }
    
    public static ArrayList<String> datesSale(){
        ArrayList<String> list = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT date FROM sales";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                i++;
                list.add(rs.getString("date"));
                if(i == 1){
                    continue;
                }
                if(list.get(i - 1).equals(rs.getString("date")))
                    continue;
                list.add(rs.getString("date"));
                
                
            }

        }catch(Exception ex){
            System.out.println(ex+"");
        }
        return list;
    }
    
    public static float monySales(String date){
        float sum = 0;
        Connection con = null;
        try {
            con = getConnection();
            String sql = "SELECT sum FROM sales WHERE date = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sum += rs.getFloat("sum");
            }
            
        } catch (Exception e) {
            System.out.println(e+"");
        }
        return sum;
        
    }
    
    //UserController 
    public static ObservableList<Sale> usersController(){
        Connection con = null;
        String sql = "SELECT username FROM sales";
        ObservableList<Sale> users = FXCollections.observableArrayList();
        
        try{
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users.add(new Sale(rs.getString("username")));
            }
        }catch(Exception ex){
            System.out.println(ex+"");
        }
        return users;
    }
    
   public static float getSumOFOneDateByUser(String date, String username) {
    float sum = 0;
    Connection con = null;
    try {
        con = getConnection();
        String sql = "SELECT sum FROM sales WHERE date = ? AND username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, date);
        ps.setString(2, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            float sumFromDatabase = rs.getFloat("sum");
            System.out.println("Sum from Database: " + sumFromDatabase);
            sum += sumFromDatabase;
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // Close the database connection in a finally block
        // (make sure to handle exceptions here as well)
    }
    System.out.println("Final Sum: " + sum);
    return sum;
}


  
}
