package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReportLoginWrittenController implements Initializable {

    @FXML
    private Label output;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            int Count=0;
        try {  
            
            File x= new File("data","temp.txt");
            Scanner src = new Scanner(x);
            String name=src.next();
            
            try {
                File f;
                f = new File("data","allLogin.txt");
                src = new Scanner(f);
                while(src.hasNext())
                {
                    String i=src.next();
                    if(i.equals(name))
                        Count++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReportLoginWrittenController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportLoginWrittenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        output.setText(Count+" Times.");
            
    }    

    @FXML
    private void onClickExit(ActionEvent event) throws IOException {
        Stage stage = (Stage) output.getScene().getWindow();
            stage.close();
    }

    @FXML
    private void OnclickGraph(ActionEvent event) {
    }

    @FXML
    private void onClickPrintPdf(ActionEvent event) {
    }
    
}
