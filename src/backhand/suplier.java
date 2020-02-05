package backhand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class suplier extends person {
    
    int pendingRequests;
    int totalSupplied;
    int totalPayment;

    

    @Override
    public void setPersonalData(String fName){
        try {
            File f;
            f = new File("data",fName);
            try (Scanner src = new Scanner(f)) {
                boolean flag=false;
                String read="";
                while(src.hasNext())
                {
                    String i=src.next();
                    String[] line =i.split(",");
                    this.userName=line[0];
                    this.age=line[1];
                    this.address=line[2];
                    this.gender=line[3];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setEventData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPersonalData() {
        String str=userName+","+age+","+address+","+gender;
        return str;
    }
    
}
