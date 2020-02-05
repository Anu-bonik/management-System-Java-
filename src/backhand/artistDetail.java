package backhand;

import javafx.beans.property.SimpleStringProperty;

public class artistDetail {
    private SimpleStringProperty name;
    private SimpleStringProperty time;
    
    
    public  artistDetail(String name, String time)
    {
        this.name=new SimpleStringProperty(name);
        this.time=new SimpleStringProperty(time);
        System.out.println("artist");
    }
}
