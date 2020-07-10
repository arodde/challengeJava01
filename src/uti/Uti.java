package uti;

import monApplication.research.Employee;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class Uti{

//    private Scanner sc= new Scanner(System.in);

    public static void info(String sClasse, String sMethode, String sCommentaire){
        String sLaClasse = sClasse;
        String sLaMethode = sMethode;
        String sLeCommentaire = sCommentaire;
        System.out.print("=====> "+sLaClasse+" ");
        System.out.print("=====> "+sLaMethode);
        if(sLeCommentaire!=""){
            System.out.print(" =====> "+sLeCommentaire);
        }
        System.out.println(".");
    }
    public static void mess(String message){
        System.out.println(">>>======>  "+message);
    }
    public static boolean recommencer(String sQuestion, String sOption1, String sOption2){
        /*
        * valide la poursuite d'une option selon le choix de l'utilisateur
        * */
        String sConsigne="";
        String sChoix="";
        boolean bOk= false;
        // contrôle de la saisie
        while(!bOk){
            sConsigne = "Procéder à une nouvelle conversion? (O/N)";
            sConsigne = sQuestion+" ("+sOption1+"/"+sOption2+")";
            sChoix = choixLettre(sConsigne,sOption1,sOption2);
            if(sChoix.equals(sOption1) || sChoix.equals(sOption2)){
//                System.out.println("une proposition valide : "+sOption1 +" ou "+sOption2);
                bOk = true;
            }
            else
            {
//                System.out.println("une proposition valide : non");
            }
        }
        //
        if(sChoix.equals(sOption1)){ // sChoix == sOption1
            System.out.println("recommencer : oui");
            return true;
        }
        else // sChoix == sOption2
        {
            System.out.println("recommencer : non");
            return false;
        }
    }
    public static String choixLettre(String sConsigne, String sProposition1, String sProposition2){
        /*
        * contrôle la bonne saisie d'une lettre entre les 2 options proposées
        * */
        Scanner sc= new Scanner(System.in);
        String sChoix="";
        boolean bOk= false;
            while(!bOk){
            System.out.println(sConsigne);
            System.out.println("Votre choix? : "+sProposition1+"/"+sProposition2);
            sChoix = sc.nextLine();
            System.out.println(sChoix);
            sChoix = sChoix.toUpperCase();
            System.out.println(sChoix);
            if(sChoix.equals(sProposition1) || sChoix.equals(sProposition2) ){
//                System.out.println("une proposition valide : oui");
                bOk = true;
            }
            else
            {
//                System.out.println("une proposition valide : non");
            }
        }
        return sChoix;
    }
    public static double arrondi(double A, int B) {
        /**
         arrondi A à B chiffres après la virgule
         */
        return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
    }
    public static void sep(){
        System.out.println("-------------------------------------------------------------------------");
    }
    public static void utilisationSerializationAndDeserializationFile(){
        /*
         *  pour un fichier d'extension .ser
         *   crée un fichier .ser
         *   crée un objet à partir du fichier .ser
         *   RIEN A VOIR AVEC LE FORMAT JSON
         * */
        String fname ="xyztmp\\employee.ser";
        obVersFi(fname);
        fiVersOb(fname);
    }
    public static void obVersFi(String fname){ // serialization
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /xyztmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    public static void fiVersOb(String fname){ // deserialization
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream(fname);
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
    public static Map<String, Object> getFieldNamesAndValues(final Object obj, boolean publicOnly)
            throws IllegalArgumentException,IllegalAccessException
    {
        Class<? extends Object> c1 = obj.getClass();
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = c1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            if (publicOnly) {
                if(Modifier.isPublic(fields[i].getModifiers())) {
                    Object value = fields[i].get(obj);
                    map.put(name, value);
                }
            }
            else {
                fields[i].setAccessible(true);
                Object value = fields[i].get(obj);
                map.put(name, value);
            }
        }
        return map;
    }
}
