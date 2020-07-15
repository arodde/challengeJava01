package monApplication;

import monApplication.classApi.City;
import monApplication.research.TutorialJSONSimple;
import org.json.simple.JSONArray;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uti.Uti;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestApi  {
    public String forecastType[] = new String[7];
    public String token;
    public String param;

    //    String request="";
//    URL url=new URL();
//    String token="";
//    String pathResources="";
//    public RequestApi(){
//        Uti.info("RequestApi","RequestApi","");
//        request = url+"/"+pathResources+"/"+token;
//        System.out.println("requête : "+request);
//    }
//    public RequestApi(URL url , String pathResources , String token){
//        Uti.info("RequestApi","RequestApi","");
//        this.url = url;
//        this.pathResources = pathResources;
//        this.token = token;
//        this.request = this.url+"/"+this.pathResources+"/"+this.token;
//        System.out.println("requête : "+request);
//    }
    public static void main(String[] args){
        Uti.info("RequestApi","main","");
        RequestApi requestApi = new RequestApi();
    }
    RequestApi(){
        Uti.info("RequestApi","RequestApi()","");
        initialisation();
        x1a();
//        x1b();
//        x2();
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
    }
    public void x1a() {
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
        Uti.info("RequestApi","x1a","");
        City city=new City();
        JSONArray jsonArrayCity = null;
        String insee="10300";
        param=(insee!=""?"&insee="+insee:"");
        try {
            // GET
            // this url is composed of the forecast type, the token, and the param
            URL url = urlConception(forecastType[0],token,param);
            System.out.println(url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String antS =readStream(in);
//                System.out.println("antS : "+antS);
                String s =  antS.substring(8,(antS.length()-1));
//                String s =  antS;
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
                    System.out.println("city : " +  map.get("city"));
                    JSONParser jsonParser1 = new JSONParser();
                    System.out.println(s);

                    TutorialJSONSimple tutorialJSONSimple= new TutorialJSONSimple();
//                    String s = "xyztmp/tutoJsonSimple/city.json";
                    city = tutorialJSONSimple.displaysCityJSONStringContentFromJsonString(s);
                    System.out.println(city.toString());

//                    TutorialJSONSimple tutorialJSONSimple = new TutorialJSONSimple();
//                    Object object =  tutorialJSONSimple.displaysCityJSONStringContent(s);
//                    city = (City) object;
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
    public void x1b() {
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
         */
        Uti.info("RequestApi","x1b","");
        City city=new City();
        JSONArray jsonArrayCity = null;
        String forecastType[] = new String[7];
//        String insee="77315";
        String cityName="Tralala";

//        String param=(insee!=""?"&insee="+insee:"");
        String param=(cityName!=""?"&search="+cityName:"");
        String token;
        forecastType[0] = "location/city";
        forecastType[1] = "location/cities";
        forecastType[2] = "forecast/nextHours";
        forecastType[3] = "forecast/daily";
        forecastType[4] = "forecast-period";
        forecastType[5] = "forecast-hour";
        forecastType[6] = "forecast-map-day";
        token = "3b057412276cdbe9dcf39dc6ec656d8ef3635c6804b74792cdbbf5d851b8c29f";
        try {
            // GET
            // this url is composed of the forecast type, the token, and the param
            URL url = urlConception(forecastType[1],token,param);
//            URL url = urlConception(forecastType[1],token,param);
            System.out.println(url);
// get a city with a numerous
// https://api.meteo-concept.com/api/location/city?token=MON_TOKEN&insee=35238
// get a list of cities with
// https://api.meteo-concept.com/api/location/cities?token=MON_TOKEN&search=Rennes

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String antS =readStream(in); //<in Json en String -
                // convertir en jSON ici
                System.out.println("antS : "+antS);
//                String s =  antS.substring(8,(antS.length()-1));
                String s =  antS;
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
//                    System.out.println("city : " +  map.get("city"));
//                    city=(City) map.get("city");
                    JSONParser jsonParser1 = new JSONParser();
//                   city.copyCity((Object) jsonParser1.parse(s));

//                 city=  city.clone(jsonParser1.parse(s));
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
    private String readStream(InputStream is) throws IOException {
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
