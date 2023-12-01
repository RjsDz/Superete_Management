
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
public class FXMLAddUserController implements Initializable {

    @FXML
    private TextField userLab;

    @FXML
    private TextField passLab;

    @FXML
    private Button addButt;

    @FXML
    private Button deleteButt;
    
    public void add(){
        try{
            if(userLab.getText().equals("") || passLab.getText().equals("")){
                JOptionPane.showMessageDialog(null,"the password or the username is empty");
                
            }
            DB.insertUser(userLab.getText(), passLab.getText());
        }catch(Exception e){
            System.out.println(e+"");
        }finally{
           userLab.setText("");
           passLab.setText("");
       }
    }
    
    public void delete(){
       try{
           DB.deleteUser(userLab.getText());
       }catch(Exception e){
           System.out.println(e+"");
       }finally{
           userLab.setText("");
           passLab.setText("");
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
