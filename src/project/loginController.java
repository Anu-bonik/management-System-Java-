package project;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController implements Initializable {

    @FXML
    private Button loginClick;
    @FXML
    private Button signUpClick;
    @FXML
    private AnchorPane loginanchor;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private Button home;
    @FXML
    private Label reply;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   

    @FXML
    private void loginClickOnAction(ActionEvent event) throws IOException, InterruptedException {
        //File dir = new File("C:\\Users\\Nuik\\Documents\\5th\\OOP\\New Folder\\PROJECT\\src\\data");
        File f;
        f = new File("data","login.txt");
        
        try
        {     
            Scanner src = new Scanner(f);
            boolean flag=false;
            while(src.hasNext())
            {
                String i=src.next();
                String[] id= i.split(",");
                
                        File x;
                        x = new File("data","temp.txt");
                        FileWriter help;
                        help= new FileWriter(x);
                        help.write(name.getText());
                        help.close();
                        x=new File("data","allLogin.txt");
                        if(x.exists())  help= new FileWriter(x,true);
                        else help= new FileWriter(x);
                        help.append(name.getText()+"\n");
                        help.close();
                        System.out.println("worked");
                System.out.println(id[0]+"=="+name.getText());
                if(id[0].equals(name.getText())  && id[1].equals(password.getText()))
                    {
                        if("client".equals(id[2]))
                        {
              
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("clientUI.fxml"));
              
                            Parent tempParent = loader.load();
              
                            Scene personViewScene = new Scene(tempParent);
                            
                            ClientUIController controller = loader.getController();
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            controller.getData(id[0]);
                            window.setScene(personViewScene);
                            window.show();
                            flag=true;
                            break;
                        }
                        else if("admin".equals(id[2]))
                        {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("admin.fxml"));
                             System.out.println("2.1");
                            Parent tempParent = loader.load();
                             System.out.println("2.1");
                            Scene personViewScene = new Scene(tempParent);
                            AdminController controller = loader.getController();
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            controller.getData(id[0]);
                            window.setScene(personViewScene);
                            window.show();
                            flag=true;
                            break;
                        }
                        else if("supplier".equals(id[2]))
                        {
                            System.out.println("worked now");
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("supplier.fxml"));
                            Parent tempParent = loader.load();
                            Scene personViewScene = new Scene(tempParent);
                            SupplierController controller = loader.getController();
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            controller.getData(id[0]);
                            window.setScene(personViewScene);
                            window.show();
                            flag=true;
                            break;
                        }
                        else if("Manager".equals(id[2]))
                        {
                            System.out.println("worked now");
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("managerUI.fxml"));
                            Parent tempParent = loader.load();
                            Scene personViewScene = new Scene(tempParent);
                            ManagerUIController controller = loader.getController();
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            controller.getData(id[0]);
                            window.setScene(personViewScene);
                            window.show();
                            flag=true;
                            break;
                        }
                                
                    }
                
            }
            
            if(!flag)
            {
                reply.setText("Sorry, Wrong User name or Password. Retry or sign up please.");
                password.setText("");
            }
            src.close();
        }
        catch(IOException e)
        {
            System.out.println("Could not open the file");
            reply.setText("Sorry, Wrong User name or Password. Retry or sign up please.");
        }
    }

    @FXML
    private void signUpClickOnAction(ActionEvent event) throws IOException {
            Stage stage = (Stage) loginClick.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("signUp.fxml")));
            stage.setScene(scene);
    }

    @FXML
    private void OnclickHome(ActionEvent event) throws IOException {
            Stage stage = (Stage) loginClick.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("publicUI.fxml")));
            stage.setScene(scene);
    }
    
}
