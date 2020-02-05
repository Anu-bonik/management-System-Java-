
package project;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MarriageCeremonyEventController implements Initializable {
    @FXML
    private SplitMenuButton Home;
    private String fname;
    private String passnext;
    @FXML
    private TextField Location;
    @FXML
    private ComboBox religion;
    @FXML
    private TextField guest;
    @FXML
    private RadioButton VipYes;
    @FXML
    private RadioButton ViipNo;
    @FXML
    private DatePicker MarriageDate;
    @FXML
    private TextField budget;
    @FXML
    private TextField groomName;
    @FXML
    private TextField brideName;
    @FXML
    private CheckBox bengali;
    @FXML
    private CheckBox chinese;
    @FXML
    private CheckBox italian;
    @FXML
    private CheckBox continental;
    @FXML
    private CheckBox mexican;
    @FXML
    private RadioButton musicYes;
    @FXML
    private RadioButton MusicNO;
    
    private ToggleGroup tg;
    private ToggleGroup tg2;
    @FXML
    private TextField eventName;

    
     public void getData(String t)
    {
        passnext=t;
        fname=t+"event.bin";
        System.out.println(t);
        System.out.println(fname);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        religion.getItems().addAll("Hindu","Muslim","Christian");
        religion.setValue("Muslim");
        
        tg = new ToggleGroup();
        VipYes.setToggleGroup(tg);
        ViipNo.setToggleGroup(tg);
        VipYes.setSelected(true);
        
        tg2 = new ToggleGroup();
        musicYes.setToggleGroup(tg2);
        MusicNO.setToggleGroup(tg2);
        musicYes.setSelected(true);
        
    }    

    @FXML
    private void onClickLogOut(ActionEvent event) throws IOException {
            Stage stage = (Stage) Home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
        
    }

    @FXML
    private void onClickHome(ActionEvent event) throws IOException {
             Stage stage = (Stage) Home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickSubmit(ActionEvent event) throws IOException {
        String str="ceremony"+","+eventName.getText()+","+brideName.getText()+","+groomName.getText()+","+Location.getText()+","+
                MarriageDate.getValue()+","+guest.getText()+","+VipYes.isSelected()+","+
                budget.getText()+","+bengali.isSelected()+","+chinese.isSelected()+","+
                italian.isSelected()+","+continental.isSelected()+","+mexican.isSelected()+
                ","+musicYes.isSelected()+"/n";
        System.out.println(str);
        
                File file = new File("data/eventdata",fname);
                
		/*byte[] data = str.getBytes(StandardCharsets.UTF_8);        
                FileOutputStream fos;
                
                if(file.exists()) fos = new FileOutputStream(file,true);
                else fos = new FileOutputStream(file);
                
                fos.write(data);
                System.out.println(Arrays.toString(data));
		System.out.println("Successfully written data to the file");
                fos.close();    */
                
                
               
               try (FileOutputStream fos = new FileOutputStream(file,true);
			//BufferedOutputStream bos = new BufferedOutputStream(fos);
            		DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeBytes(str);
			System.out.println("Successfully written data to the file");
		}
		catch (IOException e) {
                    System.out.println("Havent Work");
		}

               
            /*FileWriter masterFw;
            if(file.exists())  masterFw= new FileWriter(file,true);
            else masterFw= new FileWriter(file);
            
            masterFw.write(str);
            masterFw.close();*/
            
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
    
}
