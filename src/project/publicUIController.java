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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class publicUIController implements Initializable {
    
    private Label label;
    @FXML
    private Button home;
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem login;
    @FXML
    private MenuItem signUp;
    @FXML
    private Button contact;
    @FXML
    private Button aboutUS;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeOnClick(ActionEvent event) throws IOException {
     Stage stage2 = (Stage) home.getScene().getWindow();
     stage2.close();
         Scene scene2 = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
         Stage stage= new Stage();
         stage.setScene(scene2);
         //stage.setResizable(false);
         stage.show();
    }


    @FXML
    private void LoginOnClick(ActionEvent event) throws IOException {
      
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
         //stage.setResizable(false);
         stage.setScene(scene);
    }

    @FXML
    private void signupOnClick(ActionEvent event) throws IOException {
      
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("signUp.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
         //stage.setResizable(false);
         stage.setScene(scene);
    }

    @FXML
    private void onClickContact(ActionEvent event) throws IOException {
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("contactUs.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
         //stage.setResizable(false);
         stage.setScene(scene);
    }

    @FXML
    private void menuOnClick(ActionEvent event) {
    }

    @FXML
    private void AboutUsOnClick(ActionEvent event) throws IOException {
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("aboutUS.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
         //stage.setResizable(false);
         stage.setScene(scene);   
    }

    @FXML
    private void linkClickAction(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
         Stage stage = (Stage) home.getScene().getWindow();
         //stage.setResizable(false);
         stage.setScene(scene);   
    }

    
}
