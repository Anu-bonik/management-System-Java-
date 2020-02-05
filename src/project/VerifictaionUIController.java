package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nuik
 */
public class VerifictaionUIController implements Initializable {

    @FXML
    private TextField code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickSubmit(ActionEvent event)  {
        
         File temp=new File("data","temp.txt");
        try (FileWriter f = new FileWriter(temp)) {
            if( "1234".equals(code.getText()))
                f.write("correct");
            else  f.write("wrong");
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(VerifictaionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.close();
    }
    
}
