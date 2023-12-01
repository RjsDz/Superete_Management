
package supermarketproject;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author ANIS INFO
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private PasswordField passLab;

    @FXML
    private TextField userLab;

    @FXML
    private Button enterBut;

    @FXML
    private Button cancelBut;
    
    @FXML
    private Button dbconf;
  
    public void enter(ActionEvent e) throws IOException{
        try{
            if(!TextFileDBConfig.isExistsFile()){
                JOptionPane.showMessageDialog(null, "Check you're connection with data base");
            }
               // TextFileDBConfig.setHostAndPort("127.0.0.1", "3306");
                
            DB.getConnection();
        }catch(Exception ex){
            Pages page = new Pages("FXMLDataBaseConnection.fxml", dbconf);
            page.setTitle("Change Data Base Config");
            page.fixSize(true);
            page.newStrage();
            System.out.println(ex+"");
        }
        boolean admin; 
        boolean check = false;
        try{
            admin = DB.isAdmin(userLab.getText(), passLab.getText());
            check = DB.isUserExist(passLab.getText(), userLab.getText());
            if(passLab.getText().equals("") || userLab.getText().equals("")){
                JOptionPane.showMessageDialog(null, "You have to fill the inputes");
                return;
            }else{
                 passLab.setText("");
            }
        
        if(admin)
            Admin.setAdmin(true);
        
        if(check){
            Employee.name = userLab.getText();
             Pages p = new Pages("FXMLMainFace.fxml", userLab,true);
             p.fixMinWidth(1200);
             p.changePage();
             
        }else{
            JOptionPane.showMessageDialog(null, "Your Password Or Username is uncorect!!!");
        }
        }catch(Exception ex){
           // System.out.println(ex+"");
        Pages p = new Pages("FXMLDataBaseConnection.fxml", dbconf);
        p.fixSize(true);
        p.setTitle("Change Data Base Connection");
        p.newStrage();
        }
        
        

    }
    
    
    public void cancel(){
        Platform.exit();
                
    }
    
    public void  changeDBconfigFunc(){
        Pages p = new Pages("FXMLDataBaseConnection.fxml", dbconf);
        p.fixSize(true);
        p.setTitle("Change Data Base Connection");
        p.newStrage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()->{
            
        
        });
      
    }    
    
}
