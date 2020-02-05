/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import backhand.artistDetail;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nuik
 */
public class ConcertEventController implements Initializable {
    @FXML
    private MenuButton home;
    @FXML
    private TableView <artistDetail> tableview;
    @FXML
    private TableColumn<artistDetail,String> NameColumn;
    @FXML
    private TableColumn <artistDetail,String> TimeColumn;
    @FXML
    private MenuButton ageGroup;
    @FXML
    private DatePicker eventDate;
    @FXML
    private TextField locationDate;
    @FXML
    private TextField timeRange;
    @FXML
    private CheckBox privacyMod1;
    @FXML
    private CheckBox privacyMod2;
    @FXML
    private TextField ticketPrice;
    @FXML
    private TextField maxAllowed;
    @FXML
    private CheckBox standingCheck;
    @FXML
    private CheckBox sittingChrck;
    @FXML
    private CheckBox vipCheck;
    @FXML
    private TextField artistName;
    @FXML
    private TextField performTime;
    @FXML
    private TextField eventName;
    private ToggleGroup tg;
    private String passnext;
    private String fname;

    
    
    
     public void getData(String t)
    {
        passnext=t;
        fname=t+"event.bin";
        System.out.println(t);
        System.out.println(fname);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableview.setEditable(true);
        
        NameColumn.setCellValueFactory(new PropertyValueFactory<artistDetail,String>("name"));
        TimeColumn.setCellValueFactory(new PropertyValueFactory<artistDetail,String>("time"));
        tableview.setItems(getArtist());
        tableview.setEditable(true);
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }    

    @FXML
    private void onClickLogOut(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onCLickHome(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickSubmit(ActionEvent event) throws IOException {
        
        String str="concert"+","+eventName.getText()+","+vipCheck.isSelected()+","+eventDate.getValue();
        
        File file = new File("data/eventdata",fname);
        
        try (FileOutputStream fos = new FileOutputStream(file,true);
			//BufferedOutputStream bos = new BufferedOutputStream(fos);
            		DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeBytes(str);
			System.out.println("Successfully written data to the file");
		}
		catch (IOException e) {
                    System.out.println("Havent Work");
		}
        
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("clientUI.fxml"));
              
                            Parent tempParent = loader.load();
              
                            Scene personViewScene = new Scene(tempParent);
                            
                            ClientUIController controller = loader.getController();
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            controller.getData(passnext);
                            window.setScene(personViewScene);
                            
                            Stage st= new Stage();
                            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("SuccesfulPromt.fxml")));
                            st.setScene(scene);
                            st.show();
        
    }

    @FXML
    private void onClickAddtoTable(ActionEvent event) {
        artistDetail newArtist = new artistDetail(artistName.getText(),
                                       performTime.getText());
        
        tableview.getItems().add(newArtist);
    }
    
    public ObservableList<artistDetail> getArtist()
    {
        ObservableList<artistDetail> artist = FXCollections.observableArrayList();
        artist.add(new artistDetail("Anu","11.20"));
        return artist;
    }
    
}
