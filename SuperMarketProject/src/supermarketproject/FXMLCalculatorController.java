
package supermarketproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class FXMLCalculatorController implements Initializable {
    @FXML
    private Button but0;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;

    @FXML
    private Button but4;

    @FXML
    private Button but5;

    @FXML
    private Button but6;

    @FXML
    private Button but7;

    @FXML
    private Button but8;

    @FXML
    private Button but9;

    @FXML
    private Button butC;

    @FXML
    private Button butDel;

    @FXML
    private Button butDot;

    @FXML
    private Button butEq;

    @FXML
    private Button butL;

    @FXML
    private Button butMin;

    @FXML
    private Button butMul;

    @FXML
    private Button butP;

    @FXML
    private Button butPM;

    @FXML
    private Button butR;

    @FXML
    private Label procLab;

    @FXML
    private Label resLab;
    
    
    public void but1Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"1");
    }
    
    public void but2Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"2");
    }
    
    public void but3Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"3");
    }
    
    public void but4Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"4");
    }
    
    public void but5Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"5");
    }
    
    public void but6Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"6");
    }
    
    public void but7Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"7");
    }
    
    public void but8Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"8");
    }
    
    public void but9Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"9");
    }
    
    public void but0Func(){
        String proc = procLab.getText();
        procLab.setText(proc+"0");
    }
    
    public void butDotFunc(){
         String proc = procLab.getText();
       if(proc.endsWith(".")){
           return;
       }else{
           procLab.setText(proc+".");
       }
    }
    
    public void butPMFunc(){
        String proc = procLab.getText();
        procLab.setText(proc+"-");
    }
    
    public void butMiFunc(){
        String proc = procLab.getText();
        procLab.setText(proc+"-");
    }
    
    public void butMulFunc(){
         String proc = procLab.getText();
       if(proc.endsWith("x")){
           return;
       }else{
           procLab.setText(proc+"x");
       }
    }
    
    public void butDivFunc(){
          String proc = procLab.getText();
       if(proc.endsWith("/")){
           return;
       }else{
           procLab.setText(proc+"/");
       }
    }
    
    public void butLFunc(){
        String proc = procLab.getText();
        if(proc.length() != 0 )
            if(!proc.endsWith("+") && !proc.endsWith("-") && !proc.endsWith("x") && !proc.endsWith("/") && !proc.endsWith("("))
                return;
        procLab.setText(proc+"(");
    }
    
    public void butRFunc(){
        String proc = procLab.getText();
        procLab.setText(proc+")");
    }
    
    public void clearFunc(){
        procLab.setText("");
        resLab.setText("0");
    }
    
    public void delFunc(){
        String s = procLab.getText();
        String d = s.substring(0, s.length() - 1);
        procLab.setText(d);
    }
    
    public void buttP(){
        String proc = procLab.getText();
        procLab.setText(proc+"+");
    }
    
    public void result(){
        try {
            String rs = procLab.getText();
            double res = resultCal(rs);
            resLab.setText(res+"");
        } catch (Exception e) {
            resLab.setText(e+"");
        }
    }
    
    
    
    
    
    
    public double resultCal(String expression){
        double result = 0;
        try {
            Expression exp = new ExpressionBuilder(expression.replace("x", "*")).build();
            result = exp.evaluate();
        } catch (Exception e) {
            resLab.setText("Error");
        }
        return result;
    }  
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
        resLab.setText("0");
        
        });
        
    }    
    
}
