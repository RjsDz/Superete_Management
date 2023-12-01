
package supermarketproject;


public class Admin {
    private static boolean admin;

    public Admin() {
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        Admin.admin = admin;
    }
    
    
}
