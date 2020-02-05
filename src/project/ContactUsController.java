package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ContactUsController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button login;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeAction(ActionEvent event) throws IOException {
        
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
        Stage stage = (Stage) home.getScene().getWindow();
         stage.setScene(scene);
    }

    @FXML
    private void onLogin(ActionEvent event) throws IOException {
         
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
//         stage.setResizable(false);
         stage.setScene(scene);
    }
    
}
