package supermarketproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class FXMLDataBaseConnectionController implements Initializable {

    @FXML
    private Button cancelBut;

    @FXML
    private Button changeBut;

    @FXML
    private TextField hostInp;

    @FXML
    private TextField portInp;
    
    public void exit(){
        portInp.getScene().getWindow().hide();
    }
    
    public void change(){
        String host = hostInp.getText().trim();
        String port = portInp.getText().trim();
        if(host.equals("") || port.equals("")){
           // TextFileDBConfig.setHostAndPort(host, port);
            JOptionPane.showMessageDialog(null, "Fill all the inputs field");
            return;
        }else{
            TextFileDBConfig.setHostAndPort(host, port);
            JOptionPane.showMessageDialog(null, "The process was successfully");
            hostInp.setText("");
            portInp.setText("");
            Platform.exit();
        }  
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            if(TextFileDBConfig.isExistsFile()){
                hostInp.setText(TextFileDBConfig.getHost());
           portInp.setText(TextFileDBConfig.getPort());
            }
            
        
        
        });
        
        
    }    
    
}
