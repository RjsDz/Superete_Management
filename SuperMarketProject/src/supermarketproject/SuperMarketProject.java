package supermarketproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SuperMarketProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLCalculator.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.show();
        stage.setTitle("Rjssofts_Sales_Management ~V : 1.0.1");
        
       Image img = new Image("/supermarketproject/imgs/logo.png");
       stage.getIcons().add(img);

    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}



