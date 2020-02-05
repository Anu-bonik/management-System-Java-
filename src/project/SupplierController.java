package project;

import backhand.suplier;
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
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class SupplierController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private MenuItem pendings;
    @FXML
    private MenuItem newRequest;
    @FXML
    private Button logout;
    @FXML
    private Button report;
    @FXML
    private Button historyButton;
    @FXML
    private ImageView image;
    private Label age;
    private Label address;
    @FXML
    private Label nameOutput;
    @FXML
    private Label ageOutput;
    @FXML
    private Label addressOutput;
    @FXML
    private Label genderOutput;

    
    public void getData(String t)
    {
        System.out.println(t);
        suplier obj= new suplier() ;
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
        Stage stage = (Stage) homeButton.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickPending(ActionEvent event) {
        
    }

    @FXML
    private void onClickRequest(ActionEvent event) {
    }

    @FXML
    private void onClickLogout(ActionEvent event) throws IOException {
           Stage stage = (Stage) homeButton.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickReport(ActionEvent event) {
    }

    @FXML
    private void onClickHistory(ActionEvent event) {
    }
    
}
