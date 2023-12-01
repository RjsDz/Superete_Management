
package supermarketproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ANIS INFO
 */
public class FXMLUpdatePassController implements Initializable {

   
    @FXML
    private TextField currPass;

    @FXML
    private TextField newPass;

    @FXML
    private Button update;

    @FXML
    private Button exit;
    
    public void exit(){
        //Platform.exit();
        Pages p = new Pages();
        p.closeWithNode(update);
       
    }
    
    public void update(){
        String currP = "";
        String newP = "";
        currP = currPass.getText();
        newP = newPass.getText();
        if(currP.equals("") || newP.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the field");
        }
        DB.updatePassword(currP, newP);
        currPass.setText("");
        newPass.setText("");
        // Pages p = new Pages("FXMLMainFace.fxml", newPass);
        //

 // @USERS  
 
        //p.changePage();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
