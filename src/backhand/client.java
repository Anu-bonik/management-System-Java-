package backhand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client extends person {
    
    int marrigeNo;
    int annNo;
    int concertNo;
    

    @Override
    public void setPersonalData(String fName){
        try {
            System.out.println(fName);
            File f;
            f = new File("data",fName);
            try (Scanner src = new Scanner(f)) {
                
                    String i=src.next();    
                    String[] line =i.split(",");
                    this.userName=line[0];
                    this.age=line[1];
                    this.address=line[2];
                    this.gender=line[3];
                    this.email=line[4];
            }
           
        } catch (FileNotFoundException ex) {
            System.out.println("here");
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void setEventData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPersonalData() {
        String str=userName+","+age+","+address+","+gender+","+email;
        return str;
        
    }
    
}
