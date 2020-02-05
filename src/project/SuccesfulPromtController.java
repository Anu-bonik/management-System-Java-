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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nuik
 */
public class SuccesfulPromtController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void onClickButton(ActionEvent event) {
        try {
            Stage stage = (Stage) anchorpane.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(SuccesfulPromtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
