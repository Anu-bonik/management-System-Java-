package backhand;

abstract public class person {
    String userName;
    String age;
    String address;
    String gender;
    String email;
    //String ContactNo;
    
    abstract public void setPersonalData(String fName);
    abstract public void setEventData();
    abstract public String getPersonalData();
}
