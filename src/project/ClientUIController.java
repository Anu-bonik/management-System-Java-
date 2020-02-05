package project;


import backhand.client;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ClientUIController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button logout;
    @FXML
    private Label nameOutput;
    @FXML
    private Label ageoutput;
    @FXML
    private Label addressOutput;
    @FXML
    private Label genderOutput;
    @FXML
    private MenuItem totalLogin;
    @FXML
    private Label emailOutput;
    
    String[] line;
    String passnext;
    @FXML
    private ComboBox hostingEvent3;
    @FXML
    private ComboBox hostingEvent;
    @FXML
    private ComboBox hostingEvent2;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker todate;
    @FXML
    private Menu ttt;
    
     public void getData(String t)
    {
        System.out.println("pass="+t);
        
            passnext=t;
            client obj= new client() ;
            obj.setPersonalData(t+".txt");
            
            String str=obj.getPersonalData();
            System.out.println(str);
            line=str.split(",");
            nameOutput.setText(line[0]);
            ageoutput.setText(line[1]);
            addressOutput.setText(line[2]);
            genderOutput.setText(line[3]);
            emailOutput.setText(line[4]);
           
            File f;
            String n=passnext+"event.bin";
            f = new File("data/eventdata",n);
            if(f.exists())
            {
            try {
                
            System.out.println(n);
            if(f.exists())
            {
             Scanner src = new Scanner(f);
             System.out.println("try");
            while(src.hasNext())
            {
                String i=src.next();
                String[] line=i.split("/n");
                
                System.out.println(i);
                
                
                for(String item:line)
                {
                    System.out.println(item);
                    String[] id=item.split(",");
                    System.out.println(id[1]);
                    hostingEvent.getItems().add(id[1]);
                    hostingEvent3.getItems().add(id[1]);
                    hostingEvent2.getItems().add(id[1]);
                
                    hostingEvent.setValue(id[1]);
                    hostingEvent2.setValue(id[1]);
                    hostingEvent3.setValue(id[1]);
                }
                
                
            }   
            src.close();
            }
            
         
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            }
            
             
            
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void onHomeAction(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onLogoutAction(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void onClickTotalLogin(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("reportLoginWritten.fxml")));
            stage.setScene(scene);       
            stage.show();
    }

    @FXML
    private void HostMarriageAnniversary(ActionEvent event) {
        
    }

    @FXML
    private void HostMarriageCeremony(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("marriageCeremonyEvent.fxml"));
            Parent tempParent = loader.load();
            Scene personViewScene = new Scene(tempParent);
            MarriageCeremonyEventController controller = loader.getController();
            Stage window = (Stage) home.getScene().getWindow();
            controller.getData(passnext);
            window.setScene(personViewScene);
            window.show();
    }

    @FXML
    private void HostAConcert(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConcertEvent.fxml"));
            Parent tempParent = loader.load();
            Scene personViewScene = new Scene(tempParent);
            ConcertEventController controller = loader.getController();
            Stage window = (Stage) home.getScene().getWindow();
            controller.getData(passnext);
            window.setScene(personViewScene);
            window.show();
    }

    @FXML
    private void HostAConference(ActionEvent event) throws IOException {
        
    }

    private void OnClickExportUser(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);
        try (FileWriter fw = new FileWriter(f)) {
            String str="Name : "+line[0]+"\r\n"+ "Age : "+line[1]+"\r\n"+"Gender : "+line[3]+"\r\n"+"Address : "+line[2]
                    +"\r\n"+"Email : "+line[4]+"\r\n";
            System.out.println(str);
            fw.write(str);
        }
    }

    @FXML
    private void onClickGetReport(ActionEvent event) throws FileNotFoundException, IOException {
        
        int mcer=0,mann=0,con=0,conf=0,total=0;
            
            File f;
            String n=passnext+"event.bin";
            f = new File("data/eventdata",n);
            if(f.exists())
            {
             Scanner src = new Scanner(f);
             System.out.println("try");
            while(src.hasNext())
            {
                String i=src.next();
                String[] line=i.split("/n");
                
                System.out.println(i);
                
                
                for(String item:line)
                {
                    
                    System.out.println(item);
                    String[] id=item.split(",");
                    
                    LocalDate evDate=LocalDate.parse(id[5]);
                    System.out.println(evDate);
                    LocalDate frDate=fromDate.getValue();
                    System.out.println(frDate);
                    LocalDate toDate=todate.getValue();
                    
                    
                    
                    System.out.println(toDate);
                   
                    System.out.println(evDate.compareTo(frDate));
                    System.out.println(evDate.compareTo(toDate));
                    
                    if(evDate.compareTo(frDate)>=0 && evDate.compareTo(toDate)<=0)
                    {
                        total++;
                        if("ceremony".equals(id[0])) mcer++;
                        else if("anniversary".equals(id[0])) mann++;
                        else if("concert".equals(id[0])) con++;
                        else if("conference".equals(id[0])) conf++;
                    }
                        
                    
                }
                
                
            }   
            src.close();
            }
            else System.out.println("none");
            
            
            System.out.println("yahoooo");
             FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("chartDataClientEvent.fxml"));
              
                            Parent tempParent = loader.load();
              
                            Scene personViewScene = new Scene(tempParent);
                            
                            ChartDataClientEventController controller = loader.getController();
                            System.out.println("google");
                            Stage window = new Stage();
                            controller.getdata(total,mcer,mann,con,conf);
                            window.setScene(personViewScene);
                            window.show();
            
    }
}


