package project;

import backhand.manager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nuik
 */
public class ManagerUIController implements Initializable {

    @FXML
    private Label nameOutput;
    @FXML
    private Label ageOutput;
    @FXML
    private Label addressOutput;
    @FXML
    private Label genderOutput;
    @FXML
    private Button home;
    @FXML
    private Button logout;
    
    public void getData(String t)
    {
        
        manager obj= new manager() ;
        obj.setPersonalData(t+".txt");
        
        String str=obj.getPersonalData();
        String[] line=str.split(",");
        nameOutput.setText(line[0]);
        ageOutput.setText(line[1]);
        addressOutput.setText(line[2]);
        genderOutput.setText(line[3]);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void onClickHome(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickLogout(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }
    
}
