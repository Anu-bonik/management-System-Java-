/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class ChartDataClientEventController implements Initializable {
    
    int total;
    int mcer;
    int mann;
    int con;
    int conf;
    @FXML
    private BorderPane borderpane;
    
    
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

    }    

    @FXML
    private void onClickPieChart(ActionEvent event) {
                try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("PieChart.fxml"));
           Parent tempParent = loader.load();
           PieChartController controller = loader.getController();
           controller.getdata(total,mcer,mann,con,conf);
            borderpane.setCenter(tempParent);
        } catch (IOException ex) {
            Logger.getLogger(ChartDataClientEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onClickBarChart(ActionEvent event) throws IOException {
               FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("BarChart.fxml"));
           Parent tempParent = loader.load();
           BarChartController controller = loader.getController();
           controller.getdata(total,mcer,mann,con,conf);
            borderpane.setCenter(tempParent);
        }
    
    }
    
    
    

