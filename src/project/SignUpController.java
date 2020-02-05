package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private TextField accountName;
    @FXML
    private TextField userName;
    @FXML
    private TextField age;
    @FXML
    private TextField address;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label reply;
    @FXML
    private Button submit;
    @FXML
    private Button home;
    @FXML
    private ComboBox accountCombo;
    @FXML
    private ComboBox genderChoice;
    @FXML
    private TextField emailField;
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      accountCombo.getItems().addAll("client","admin","supplier","Manager");
      accountCombo.setValue("client");
      genderChoice.getItems().addAll("Male","Female");
      genderChoice.setValue("Male");
    }    
    
    private void succesful() throws IOException, InterruptedException
    {
        Scene scene2 = new Scene(FXMLLoader.load(getClass().getResource("SuccesfulPrompt.fxml")));
         Stage stage= new Stage();
         stage.setScene(scene2);
//         stage.setResizable(false);
         stage.show();   
    }

    @FXML
    private void submitAction(ActionEvent event) throws InterruptedException, FileNotFoundException, IOException {
        System.out.println(genderChoice.getValue().toString());
        if("".equals(userName.getText()) || "".equals(accountName.getText()) || "".equals(password.getText())
           || "".equals(confirmPassword.getText())||"".equals(age.getText()))
        {
         reply.setText("Fill the fields");
         return;
        }
        
        
        if(accountName.getText().length()<4 || password.getText().length()<4)
        {
            reply.setText("Name and PassWord Should be atleast 4 letter");
            accountName.setText("");
            password.setText("");
            return;
        }
        
        /*if(NotOnlyNumber())
        {
            reply.setText("Age Should Be a Number");
            return;
        }*/
        
        if(CheckExistOrNot(accountName.getText()))
        {
            accountName.setText("");
            reply.setText("name already exist, try diffrent name");
            return;
        }
        
        if("Thanks".equals(reply.getText())) return;
        
        if(confirmPassword.getText().equals(password.getText()))
           reply.setText("Thanks"); 
        else 
        {
            reply.setText("Sorry Passwords doesnt match!! Re-enter the password.");
            return;
        }
         
        
        
//        File dir = new File("C:\\Users\\Nuik\\Documents\\5th\\OOP\\New Folder\\PROJECT\\src\\data");
        File f;
        f = new File("data","login.txt");
        String fName= accountName.getText()+".txt";
        String pass=accountName.getText()+","+password.getText()+","+accountCombo.getValue().toString()+"\n";
        String str= userName.getText()+","+age.getText()+","+address.getText()+","+genderChoice.getValue().toString()
                +","+emailField.getText()+"\n";
        String eData=accountName.getText()+"event"+".txt";
        
        
        
        
        
        
       /* 
        if(!"client".equals(accountCombo.getValue().toString()))
        {
            Stage st= new Stage();
            Scene scene= new Scene(FXMLLoader.load(getClass().getResource("VerifictaionUI.fxml")));
            st.setScene(scene);
            st.show();
            Thread.sleep(5);
        }
       
        if(!"client".equals(accountCombo.getValue().toString()))
        {
            String i="";
            while(!"correct".equals(i) || !"wrong".equals(i))
            {
                
            File ch= new File("data","temp.txt");
            try (Scanner sc = new Scanner(ch)) {
                System.out.println(sc.next());
                i=sc.next();
                sc.close();
            }
            
            }
            
            try (FileWriter tt = new FileWriter(new File("data", "temp.txt"))) {
                tt.write("");
        }
            System.out.println(i);
        }
        */
        
        
        
        
        
        
            
        try{    
            
            FileWriter masterFw;
            if(f.exists())  masterFw= new FileWriter(f,true);
            else masterFw= new FileWriter(f);
            
            FileWriter e;
            try (FileWriter fw = new FileWriter(new File("data",fName))) {
                e = new FileWriter(new File("data/eventdata",eData));
                fw.write(str);
                e.write("");
                masterFw.append(pass);
            }
            e.close();
            masterFw.close();
            Stage stage = (Stage) submit.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
  //          stage.setResizable(false);
            succesful();
        }
        catch (IOException e)
        {
            System.out.println("Could not open the file");
        }
        
    }

    @FXML
    private void onClickHome(ActionEvent event) throws IOException {
            Stage stage = (Stage) home.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
    //        stage.setResizable(false);
            stage.setScene(scene);
    }

    private boolean CheckExistOrNot(String text) {
        boolean flag=false;
        try {
            File f;
            f = new File("data","login.txt");
            Scanner src = new Scanner(f);
            
            while(src.hasNext())
            {
                String i=src.next();
                String[] id= i.split(",");
                if(text.equals(id[0]))
                {
                    flag=true;
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
        
    }

    private boolean NotOnlyNumber() {
        return false;
     
    }
    
}
