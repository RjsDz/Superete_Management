
package supermarketproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class FXMLStatController implements Initializable {

    @FXML
    private BarChart<String, Number> bc;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            setDataForChart();
        
        });
       // setDataForChart();
    }

    public ArrayList<Float> sums(){
        ArrayList<Float> list = new ArrayList<>();
        ArrayList<String> dates = DB.datesSale();
        for(String s : dates){
            list.add(new Float(DB.monySales(s.toString())));
        }
        
        
        
        return list;
    }
     
    private void setDataForChart() {
        x.setLabel("Days");
        y.setLabel("Da");
        y.setLowerBound(0);
        y.setUpperBound(1000000);
        y.setTickUnit(10);
        XYChart.Series<String, Number> series = new XYChart.Series();
        
        for(String date : DB.datesSale()){
            series.getData().add(new XYChart.Data<>(date, DB.monySales(date)));
            System.out.println(date);
            System.out.println(DB.datesSale().size());
        }
        ///series.getData().add(new XYChart.Data<>("lsjfdm",255));
        for(String s: DB.datesSale()){
            System.out.println(s);
        }

        // Set the name for the series (optional)
        series.setName("Data Sales");

        // Add the series to the BarChart
        bc.getData().add(series);
    }
}

