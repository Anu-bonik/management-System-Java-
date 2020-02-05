package backhand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.ClientUIController;

public class ReportOnTotalLogin {
    
    public String TotalLogin(String userName)
    {
        int Counter=0;
        String name = null;
        File x= new File("data","allLogin.txt");
        try {
            Scanner src = new Scanner(x);
            
            while(src.hasNext())
            {
                if(src.next().equals(userName))
                {
                    Counter++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Integer.toString(Counter-1);
        
    }
    
}
