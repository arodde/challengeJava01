package monApplication.research;

import monApplication.classApi.City;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uti.Uti;

import java.io.*;
import java.util.Iterator;

public class TutorialJSONSimple {
    public static void main(String[] args){
        TutorialJSONSimple tutorialJSONSimple = new TutorialJSONSimple();
    }
    public TutorialJSONSimple(){
//        x1();
//        x2();
//       createsCityJSONFile();
//        displaysCityJSONFileContent();
        City myCity = displaysCityJSONStringContent();
        System.out.println(myCity.toString());


    }

    //        x5();

    public void x1(){
        /**
         * creates a json file with couples of key and
         * value created in this function
         */
        Uti.info("TutorialJSONSimple","x1","");
        JSONObject obj = new JSONObject();

        obj.put("name", "Pankaj Kumar");
        obj.put("age", new Integer(32));

        JSONArray cities = new JSONArray();
        cities.add("New York");
        cities.add("Bangalore");
        cities.add("San Francisco");

        obj.put("cities", cities);

        try {

            FileWriter file = new FileWriter("xyztmp/tutoJsonSimple/data.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj.toJSONString());
    }
    public void x2(){
        /**
         * displays each couple of key and value in an object
         */
        Uti.info("TutorialJSONSimple","x2","");
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader("xyztmp/tutoJsonSimple/data.json");
            Object jsonObj = null;
            try {
                jsonObj = parser.parse(reader);

                JSONObject jsonObject = (JSONObject) jsonObj;

                String name = (String) jsonObject.get("name");
                System.out.println("Name = " + name);

                long age = (Long) jsonObject.get("age");
                System.out.println("Age = " + age);

                JSONArray cities = (JSONArray) jsonObject.get("cities");

                @SuppressWarnings("unchecked")
                Iterator<String> it = cities.iterator();

                while (it.hasNext()) {
                    System.out.println("City = " + it.next());
                }
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void createsCityJSONFile(){
        /**
         * creates a json file with couples of key and
         * value created in this function
         */
        Uti.info("TutorialJSONSimple","createsCityJSONFile","");
        JSONObject city = new JSONObject();
        city.put("insee","15168");
        city.put("latitude",new Double(9.603));
        city.put("longitude",new Double(6.903));
        city.put("name","Lugarde");
        city.put("cp",new Integer(15190));
        city.put("altitude",new Integer(1010));
        try {
            FileWriter file = new FileWriter("xyztmp/tutoJsonSimple/city.json");
            file.write(city.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(city.toJSONString());
    }
    public void displaysCityJSONFileContent(){
        Uti.info("TutorialJSONSimple","displaysCityJSONFileContent","");
        /**
         * displays each couple of key and value in an object
         */

        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader("xyztmp/tutoJsonSimple/city.json");
            Object jsonObj = null;
            try {
                    jsonObj = parser.parse(reader);

                    JSONObject jsonObject = (JSONObject) jsonObj;
                    String insee = (String) jsonObject.get("insee");
                    System.out.println("Code insee = " + insee);
                    String name = (String) jsonObject.get("name");
                    System.out.println("Nom = " + name);
                    int cp = ((Long) jsonObject.get("cp")).intValue();
                    System.out.println("Code Postal = " + cp);
                    double latitude = (double) jsonObject.get("latitude");
                    System.out.println("Latitude " + latitude);
                    double longitude = (double) jsonObject.get("longitude");
                    System.out.println("Longitude = " + longitude);
                    int altitude = ((Long) jsonObject.get("altitude")).intValue();
                    System.out.println("Altitude = " + altitude);
    //                JSONArray cities = (JSONArray) jsonObject.get("cities");
    //
    //                @SuppressWarnings("unchecked")
    //                Iterator<String> it = cities.iterator();
    //
    //                while (it.hasNext()) {
    //                    System.out.println("City = " + it.next());
    //                }
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public City displaysCityJSONStringContent(/*Reader para*/){
        Uti.info("TutorialJSONSimple","displaysCityJSONFileContent","");
        /**
         * displays each couple of key and value in an object
         */
        String s = "xyztmp/tutoJsonSimple/city.json";
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object jsonObj = new JSONObject();
        City city = new City();
        try {
//            jsonObj = parser.parse(para);

            jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            String insee = (String) jsonObject.get("insee");
            String name = (String) jsonObject.get("name");
            int cp = ((Long) jsonObject.get("cp")).intValue();
            double latitude = (double) jsonObject.get("latitude");
            double longitude = (double) jsonObject.get("longitude");
            int altitude = ((Long) jsonObject.get("altitude")).intValue();
            JSONArray cities = (JSONArray) jsonObject.get("cities");

//            System.out.println("Code insee = " + insee);
//            System.out.println("Nom = " + name);
//            System.out.println("Code Postal = " + cp);
//            System.out.println("Latitude " + latitude);
//            System.out.println("Longitude = " + longitude);
//            System.out.println("Altitude = " + altitude);
//                @SuppressWarnings("unchecked")
//                Iterator<String> it = cities.iterator();
//
//                while (it.hasNext()) {
//                    System.out.println("City = " + it.next());
//                }
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
                city.insee = insee;
                city.name = name;
                city.cp = cp;
                city.latitude = latitude;
                city.longitude = longitude;
                city.altitude = altitude;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return city;
    }
}
