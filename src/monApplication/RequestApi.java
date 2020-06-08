package monApplication;

import uti.Uti;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestApi  {
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
        x1();
//        x2();
    }
    public void x1() {
        Uti.info("RequestApi","x1","");
        String formulesPossibles[] = new String[6];
        String insee="23056";
        String param=(insee!=""?"&insee="+insee:"");
        String token;
        formulesPossibles[0] = "location/city";
        formulesPossibles[1] = "forecast/nextHours";
        formulesPossibles[2] = "forecast/daily";
        formulesPossibles[3] = "forecast-period";
        formulesPossibles[4] = "forecast-hour";
        formulesPossibles[5] = "forecast-map-day";
        token = "3b057412276cdbe9dcf39dc6ec656d8ef3635c6804b74792cdbbf5d851b8c29f";
        try {
            // GET
            // this url is composed of the forecast type and the token
            URL url = new URL(
                    "https",
                    "api.meteo-concept.com",
                    "/api/" + formulesPossibles[0] + "?" +
                            "token=" + token+param);


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                System.out.println(readStream(in));
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
    public void x2(){
        Uti.info("RequestApi","x2","");
    }
}
