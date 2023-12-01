package supermarketproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class Pages  {

    private String fxmlFile;
    private Node node;
    private boolean showTop;
    private Stage s = new Stage();

    public Pages(String fxmlFile, Node node,boolean showTop) {
        this.fxmlFile = fxmlFile;
        this.node = node;
        this.showTop = showTop;
    }

    public Pages(String fxmlFile, Node node) {
        this.fxmlFile = fxmlFile;
        this.node = node;
    }

    public boolean isShowTop() {
        return showTop;
    }

    public void setShowTop(boolean showTop) {
        this.showTop = showTop;
    }
    
    public void fixSize(boolean fixed){
        this.s.setResizable(!fixed);
    }
    
    public void fixMinWidth(double minWidth){
        this.s.setMinWidth(minWidth);
    }
    
    public void setIcon(String iconPath){
        this.s.getIcons().add(new Image(iconPath));
    }
    
    
    public void setTitle(String title){
        this.s.setTitle(title);
    }
    

    public String getFxmlFile() {
        return fxmlFile;
    }

    public Node getNode() {
        return node;
    }

    public void setFxmlFile(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    
    
    public Pages() {
    }
    
    public  void changePage(){
         try {
            System.out.println("start");
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            
            Scene scene = new Scene(root);
            
            Stage s = (Stage) node.getScene().getWindow();
            s.setScene(scene);
            if(showTop)
                s.initStyle(StageStyle.UNDECORATED);
            
            s.show();
            System.out.println("changed");
        } catch (Exception ex) {
            System.out.println(ex+"");
        }
    }
    
    public void newStrage(){
         try {
            System.out.println("start");
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            
            Scene scene = new Scene(root);
            
            
            s.setScene(scene);
            
            
            s.show();
            System.out.println("changed");
        } catch (Exception ex) {
            System.out.println(ex+"");
        }
    }
    
    public void closeStage(){
        s.close();
    }
    
    public void closeWithNode(Node n){
        Stage s =(Stage) n.getScene().getWindow();
        s.close();
    }
}
