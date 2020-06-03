package monApplication.serial;

import java.io.*;

public class SerializationDeserialization {
    private Employee e ;
    public static  void main(String[] args){
        SerializationDeserialization serializationDeserialization =
                new SerializationDeserialization();
    }
    public SerializationDeserialization(){
        serializingObject();
        deserializationObject();
    }
    public void instanciationEmployee(){
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        this.e=e;
    }
    public void serializingObject(){
        instanciationEmployee();
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("xyztmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in xyztmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void deserializationObject(){
        Employee e = null;
        try {
            FileInputStream fileIn =
                    new FileInputStream("xyztmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
