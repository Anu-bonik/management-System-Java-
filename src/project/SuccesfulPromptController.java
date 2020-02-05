package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuccesfulPromptController implements Initializable {

    @FXML
    private Button home;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCLickHome(ActionEvent event) {
        Stage stage = (Stage) home.getScene().getWindow();
        stage.setResizable(false);
        stage.close();
    }
    
}
