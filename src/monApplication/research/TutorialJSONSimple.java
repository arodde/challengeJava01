package monApplication.research;

import monApplication.classApi.City;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uti.Uti;

import java.io.*;
import java.util.ArrayList;
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

//        String s = "xyztmp/tutoJsonSimple/city.json";
//        City myCity = displaysCityJSONStringContentFromJsonFile(s);
//        System.out.println(myCity.toString());
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
    public void createsCityJSONFile(City city,String filePath){
        /**
         * creates a json file with couples of key and
         * value created in this function
         * para 1 : City : an object which is going put in memory
         * para 2 : String : the address of the json file
         */
        Uti.info("TutorialJSONSimple","createsCityJSONFile","");
        JSONObject jOCity = new JSONObject();
        jOCity.put("insee",city.insee);
        jOCity.put("latitude",city.latitude);
        jOCity.put("longitude",city.longitude);
        jOCity.put("name",city.name);
        jOCity.put("cp",city.cp);
        jOCity.put("altitude",city.altitude);
        try {
            FileWriter file = new FileWriter(filePath);
            file.write(jOCity.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(jOCity.toJSONString());
    }
    public void displaysCityJSONFileContent(String filePath){
        Uti.info("TutorialJSONSimple","displaysCityJSONFileContent","");
        /**
         * displays each couple of key and value in an object of a string from a json file
         * para 1 : String: the path's file
         */

        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
//            reader = new FileReader("xyztmp/tutoJsonSimple/city.json");
            reader = new FileReader(filePath);
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
    public City displaysCityJSONStringContentFromJsonString(String jsonString){
        Uti.info("TutorialJSONSimple","displaysCityJSONFileContent","");
        /**
         * uses a JSON String from a file and create an object
         * para 1 : String : json string
         * return value : a city
         */
//        String s = "xyztmp/tutoJsonSimple/city.json";
        JSONParser parser = new JSONParser();
        Reader reader = null;
//        try {
//            reader = new FileReader(jsonString);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        JSONObject jsonObjectReceived = new JSONObject();
        JSONObject jsonObjectCity = new JSONObject();
        City city = new City();
        try {
            jsonObjectReceived = (JSONObject) parser.parse(jsonString);
            jsonObjectCity = (JSONObject) jsonObjectReceived.get("city");
            city = cityAffectation(city,jsonObjectCity);
        } catch (ParseException /*| IOException */e) {
            e.printStackTrace();
        }
        return city;
    }
    public ArrayList<City> displaysCitiesJSONStringContentFromJsonFile(String characterStringObtained) throws ParseException {
        Uti.info("TutorialJSONSimple","displaysCitiesJSONStringContentFromJsonFile","");
        /**
         * uses a JSON String from a file and create a list of cities
         * para 1 : String : path of the file
         * return value : cities
         */
//        Reader reader = null;
        JSONParser parser = new JSONParser();
        JSONArray myCities = new JSONArray();
//        JSONObject jsonObj = new JSONObject();
        JSONArray arrayObjectCities = new JSONArray();
        JSONObject jsonObjectCities = new JSONObject();
        ////        String s = "xyztmp/tutoJsonSimple/city.json";
//        try {
//            reader = new FileReader(characterStringObtained);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Uti.mess("couac 1-0");
//        try {
        //            jsonObj = parser.parse(para);
//            jsonObj = parser.parse(reader);
//            arrayObjectCities = (JSONArray) parser.parse(reader);
        jsonObjectCities = (JSONObject) parser.parse(characterStringObtained);
        arrayObjectCities = (JSONArray) jsonObjectCities.get("cities");
        myCities = (JSONArray) citiesCourse(arrayObjectCities,myCities);
        return myCities;
    }
    public ArrayList<City> citiesCourse( JSONArray arrayObjectCities,ArrayList<City> myCities){
        Uti.info("TutorialJSONSimple","citiesCourse","");
        City city ;
        //todo correction affi dernière cities vide
        for(int i = 0 ; i < arrayObjectCities.size(); i++){
            System.out.println(arrayObjectCities.get(i));
            city = new City();
            city = cityAffectation(city, (JSONObject) arrayObjectCities.get(i));
            myCities.add(city);
            city= null;
        }
        return myCities;
    }
    public City cityAffectation(City city, JSONObject jsonObjectCity){
        Uti.info("TutorialJSONSimple","cityAffectation","");
        String insee = (String) jsonObjectCity.get("insee");
        String name = (String) jsonObjectCity.get("name");
        int cp = ((Long) jsonObjectCity.get("cp")).intValue();
        double latitude = (double) jsonObjectCity.get("latitude");
        double longitude = (double) jsonObjectCity.get("longitude");
        int altitude = ((Long) jsonObjectCity.get("altitude")).intValue();
        JSONArray cities = (JSONArray) jsonObjectCity.get("cities");

        city.insee = insee;
        city.name = name;
        city.cp = cp;
        city.latitude = latitude;
        city.longitude = longitude;
        city.altitude = altitude;
        return city;
    }
}
