package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class PieChartController implements Initializable {


    int total;
    int mcer;
    int mann;
    int con;
    int conf;
    @FXML
    private PieChart pieChart;
    @FXML
    private Label label1;
    
    public void getdata(int total, int mcer, int mann, int con, int conf)
    {
        this.total=total;
        this.mcer=mcer;
        this.mann=mann;
        this.con=con;
        this.conf=conf;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
   new PieChart.Data("Ceremony", 25), 
   new PieChart.Data("Anniversary",30), 
   new PieChart.Data("Concert", 17), 
   new PieChart.Data("Conference", 65));
        
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);
        pieChart.dataProperty();
       
         pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty(), " Times"
                        )
                )
        );
         
        pieChart.setData(pieChartData);
        label1.setText("Total Hosted Events = "+total);
        
    }
    
}
