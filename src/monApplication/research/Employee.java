package monApplication.research;

import uti.Uti;

public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        Uti.info("","","");
        System.out.println("Mailing a check to " + name + " " + address);
    }

}
