/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Nuik
 */
public class BarChartController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    
    
    int total;
    int mcer;
    int mann;
    int con;
    int conf;
    
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private Label Label;
    
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
        XYChart.Series series1 = new XYChart.Series<>();      
        
        series1.getData().add(new XYChart.Data("CEREMONY", 80));
        series1.getData().add(new XYChart.Data("ANNIVERSARY", 71));
        series1.getData().add(new XYChart.Data("CONCERT", 43));
        series1.getData().add(new XYChart.Data("CONFERENCE", 20));
        Label.setText("Total Hosted Events = " +total);
        barChart.getData().addAll(series1);
        
    }    
    
    
    
}
