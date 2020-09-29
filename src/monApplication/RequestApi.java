package monApplication;

import monApplication.classApi.City;
import monApplication.research.TutorialJSONSimple;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uti.Uti;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class RequestApi  {

    public String forecastType[] = new String[7];
    private String token;
    public String param;
    public MaFen maFen;
    public HttpURLConnection urlConnection;
    public City city;

    RequestApi(MaFen maFen){
        Uti.info("RequestApi","RequestApi()","");
        this.maFen = maFen;
        initialisation();
        try {
            selectTreatmentInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void selectTreatmentInput() throws IOException {
        switch(maFen.menu.currentChoice){
            case 1:
                getCityWithInseeCode(this.maFen.topPanel.cityWeatherInformations.getText().trim());
                break;
            case 2:
                getCitiesWithInputName(this.maFen.topPanel.cityWeatherInformations.getText().trim());
                break;
        }
    }
    public void initialisation(){
        Uti.info("RequestApi","initialisation()","");
        forecastType[0] = "location/city";
        forecastType[1] = "location/cities";
        forecastType[2] = "forecast/nextHours";
        forecastType[3] = "forecast/daily";
        forecastType[4] = "forecast-period";
        forecastType[5] = "forecast-hour";
        forecastType[6] = "forecast-map-day";
        token = "3b057412276cdbe9dcf39dc6ec656d8ef3635c6804b74792cdbbf5d851b8c29f";
        maFen.topPanel.requestApi = this;
    }
    public void getCityWithInseeCode(String insee) throws IOException {
        /**
         * aim: to do a request to the api and get a json object created
         * in the memory
         * ..............................................................
         * creates an url to connect to an api meteo concept
         * httpURLConnection.
         * The request can concern:
         * - a specific city identified by a insee code <-----------------------------<<
         *          returns the specific city which the insee code or server answers 400 an error
         * - a list of cities with the same name or a part of name in common
         * - ...
         * the api returns a json file with an object or an array of json objects.
         * the json file is parsed in an json object with the appropriate class
         * (example: the class city).
         *
         */
        Uti.info("RequestApi","getCityWithInseeCode","");
        param=(insee!=""?"&insee="+insee:"");
        URL url = urlConception(forecastType[0],token,param.trim());

            if(isFormatInseeCodeRespected(insee))
            {

                establishConnectionWithApi(url);
            }

    }
    public void getCitiesWithInputName(String cityName) throws MalformedURLException { // future function's name "getCitiesWithCityName"
        /**
         * aim: to do a request to the api and get a json object created
         * in the memory
         * ..............................................................
         * creates an url to connect to an api meteo concept
         * httpURLConnection.
         * The request can concern:
         * - a specific city identified by a insee code
         * - a list of cities with the same name or a part of name in common  <--------------------------<<
         *      returns a string of jsonArray empty [] or with one city [{...}] or more cities [{...},...,{...}].
         * - ...
         * the api returns a json file with an object or an array of json objects.
         * the json file is parsed in an json object with the appropriate class
         * (example: the class city).
         *
         * https://api.meteo-concept.com/api/location/cities?token=MON_TOKEN&search=Rennes
         */
        Uti.info("RequestApi","getCitiesWithInputName","");
        City city=new City();
        param=(cityName!=""?"&search="+cityName:"");

//        param= Uti.RegularExpressionTest.translate(param);
        param= Uti.RegularExpressionTest.replaceForbiddenCharacters(param);
        URL url = urlConception(forecastType[1],token,param.trim());

        try {
            if(isFormatCityNameRespected(cityName))
            {
                establishConnectionWithApi(url);
            }
        }  catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        String testedString="abcdefghijklmnopqrstuvwxyz";
        String testedString2="aâäbcdeéèêëfghiîïjklmnoöôpqrstuùûüvwxyz";

    }

    public void oldGetCitiesWithInputName(String cityName) { // future function's name "getCitiesWithCityName"
        /**
         * aim: to do a request to the api and get a json object created
         * in the memory
         * ..............................................................
         * creates an url to connect to an api meteo concept
         * httpURLConnection.
         * The request can concern:
         * - a specific city identified by a insee code
         * - a list of cities with the same name or a part of name in common  <--------------------------<<
         *      returns a string of jsonArray empty [] or with one city [{...}] or more cities [{...},...,{...}].
         * - ...
         * the api returns a json file with an object or an array of json objects.
         * the json file is parsed in an json object with the appropriate class
         * (example: the class city).
         *
         * https://api.meteo-concept.com/api/location/cities?token=MON_TOKEN&search=Rennes
         */
        Uti.info("RequestApi","getCitiesWithInputName","");



        City city=new City();
        param=(cityName!=""?"&search="+cityName:"");

        try {
            URL url = urlConception(forecastType[1],token,param);
            System.out.println(url);


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String s =readStream(in); //<in Json en String -
                System.out.println("s : "+s);
                JSONParser jsonParser = new JSONParser();
                ContainerFactory containerFactory = new ContainerFactory() {
                    @Override
                    public Map createObjectContainer() {
                        return new LinkedHashMap<>();
                    }
                    @Override
                    public List creatArrayContainer() {
                        return new LinkedList<>();
                    }
                };
                Map map= null;
                try {
                    map = (Map) jsonParser.parse(s, containerFactory);
                    JSONParser jsonParser1 = new JSONParser();

                    System.out.println("type : "+ city.getClass());
                    System.out.println("My city is "+city.getName()+".");

                } catch(ParseException pe) {
                    System.out.println("position: " + pe.getPosition());
                    System.out.println(pe);
                }
            } finally {
                urlConnection.disconnect();
            }
        }  catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Uti.mess("sortie run");
    }
    public boolean isFormatInseeCodeRespected(String insee){
        return Uti.RegularExpressionTest.booleanTestRegex("\\d{5}|d{1}[A-Z]d{3}",insee,"structure code insee correcte","structure code insee incorrecte, besoin d'un nombre composé de 5 entiers sauf la Corse commençant par 2A ou 2B.");
    }
    public boolean isFormatCityNameRespected(String cityName){
        return Uti.RegularExpressionTest.booleanTestRegex("[A-Za-z]([a-zA-Z0-9-]|\\s)*[a-zA-Z0-9]",cityName,"nom de commune correcte","nom de commune incorrect, unique des caractères et le caractère '-'");
    }
    public void establishConnectionWithApi(URL url) throws IOException {
        Uti.info("RequestApi","establishConnectionWithApi","");
        System.out.println(url);
        urlConnection = (HttpURLConnection) url.openConnection();
        try {
           requestSelection();
        } catch (ParseException e) {
            System.out.println("la réponse de l'API ne permet pas de trouver une commune correspondant au code insee saisi.");
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
    }
    public void requestSelection() throws IOException, ParseException {
        switch(maFen.menu.currentChoice){
            case 1:
                receivedCityApiResponse();
                break;
            case 2:
                receivedCitiesApiResponse();
                break;
        }
    }
    public void receivedCityApiResponse() throws IOException, ParseException {
        Uti.info("RequestApi","receivedCityApiResponse","");
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        String characterStringObtained =readStream(in);
        System.out.println("characterStringObtained : "+characterStringObtained);
        JSONParser jsonParser = new JSONParser();
        city =extractJsonObjectFromReceiveResponse( characterStringObtained, jsonParser);
        cityConsoleDescription();
        maFen.cities.add(city);
        this.city = city;
        maFen.bottomAnswer();
    }
    public void receivedCitiesApiResponse() throws ParseException, IOException {
        Uti.info("RequestApi","receivedCityApiResponse","");
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        String characterStringObtained =readStream(in);
        System.out.println("characterStringObtained : "+characterStringObtained);
        JSONParser jsonParser = new JSONParser();
        maFen.cities =extractJsonArrayFromReceiveResponse( characterStringObtained, jsonParser);
//        maFen.cities.add(city);
        this.city = city;
        maFen.bottomAnswer();
    }
    public City extractJsonObjectFromReceiveResponse( String characterStringObtained,  JSONParser jsonParser) throws ParseException {

        Uti.info("RequestApi","extractJsonObjectFromReceiveResponse","");
        city=new City();
        ContainerFactory containerFactory = new ContainerFactory() {
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap<>();
            }
            @Override
            public List creatArrayContainer() {
                return new LinkedList<>();
            }
        };
        Map  map = (Map) jsonParser.parse(characterStringObtained, containerFactory);
        System.out.println("city : " +  map.get("city"));
        System.out.println(characterStringObtained);
        TutorialJSONSimple tutorialJSONSimple= new TutorialJSONSimple();
//                    String s = "xyztmp/tutoJsonSimple/city.json";
        city = tutorialJSONSimple.displaysCityJSONStringContentFromJsonString(characterStringObtained);
        return city;
    }
    public ArrayList<City> extractJsonArrayFromReceiveResponse( String characterStringObtained,  JSONParser jsonParser) throws ParseException {

        Uti.info("RequestApi","extractJsonArrayFromReceiveResponse","");
        ContainerFactory containerFactory = new ContainerFactory() {
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap<>();
            }
            @Override
            public List creatArrayContainer() {
                return new LinkedList<>();
            }
        };
        Map  map = (Map) jsonParser.parse(characterStringObtained, containerFactory);
        System.out.println("cities : " +  map.get("cities"));
        System.out.println(characterStringObtained);
        TutorialJSONSimple tutorialJSONSimple= new TutorialJSONSimple();
//                    String s = "xyztmp/tutoJsonSimple/city.json";
        maFen.cities = tutorialJSONSimple.displaysCitiesJSONStringContentFromJsonFile(characterStringObtained);
        return maFen.cities;
    }
    public void cityConsoleDescription(){
        Uti.info("RequestApi","cityConsoleDescription","");
        System.out.println(city.toString());
//        System.out.println("type : "+ city.getClass());
        System.out.println("My city is "+city.getName()+".");
    }
    private String readStream(InputStream is) throws IOException {
        /**
         * this function creates a string with a inputsSream got
         * para 1 : InputStream : stream
         * returns : String
         */
        Uti.info("RequestApi","readStream","");
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }

    //    public void x2(){
//        Uti.info("RequestApi","x2","");
//        City city=new City();
//        String forecastType[] = new String[6];
//        String insee="36043";
//        String param=(insee!=""?"&insee="+insee:"");
//        String token;
//        forecastType[0] = "location/city";
//        forecastType[1] = "forecast/nextHours";
//        forecastType[2] = "forecast/daily";
//        forecastType[3] = "forecast-period";
//        forecastType[4] = "forecast-hour";
//        forecastType[5] = "forecast-map-day";
//        token = "3b057412276cdbe9dcf39dc6ec656d8ef3635c6804b74792cdbbf5d851b8c29f";
//        try {
//            // GET
//            // this url is composed of the forecast type and the token
//            URL url = new URL(
//                    "https",
//                    "api.meteo-concept.com",
//                    "/api/" + forecastType[0] + "?" +
//                            "token=" + token+param);
//
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            try {
//                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                String antS =readStream(in);
//                System.out.println(antS);
////                String s =  antS.substring(8,(antS.length()-1));
//                String s =  antS;
//                System.out.println(s);
//
//                JSONParser jsonParser = new JSONParser();
//                ContainerFactory containerFactory = new ContainerFactory() {
//                    @Override
//                    public Map createObjectContainer() {
//                        return new LinkedHashMap<>();
//                    }
//                    @Override
//                    public List creatArrayContainer() {
//                        return new LinkedList<>();
//                    }
//                };
//                Map map= null;
//                try {
//                    map = (Map) jsonParser.parse(s, containerFactory);
//                    System.out.println("city : " +  map.get("city"));
//                    JSONParser jsonParser1 = new JSONParser();
////                   city.copyCity((Object) jsonParser1.parse(s));
//
////                 city=  city.clone(jsonParser1.parse(s));
//                    city.toString();
//                    System.out.println("My city is "+city.name+".");
//                } catch(ParseException pe) {
//                    System.out.println("position: " + pe.getPosition());
//                    System.out.println(pe);
//                }
//                city.toString();
//            } finally {
//                urlConnection.disconnect();
//            }
//        }  catch (
//                MalformedURLException e) {
//            e.printStackTrace();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//        Uti.mess("sortie run");
//    }
    public URL urlConception(String forecastType, String token, String param) throws MalformedURLException {
        /**
         * returns url for a specific request
         * --> forecastType  forecastType[0] = "location/city";
         *       // get a city with a numerous
         *           // https://api.meteo-concept.com/api/location/city?token=MON_TOKEN&insee=35238
         * --> forecastType  forecastType[1] = "location/cities";
         *       // get a list of cities with
         *           // https://api.meteo-concept.com/api/location/cities?token=MON_TOKEN&search=Rennes
         */
        Uti.info("RequestApi","urlConception","");
        URL url = new URL(
                "https",
                "api.meteo-concept.com",
                "/api/" + forecastType + "?" +
                        "token=" + token+param);
        return url;
    }
}
