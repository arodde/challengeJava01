package monApplication.classApi;

import uti.Uti;

import java.io.Serializable;

public class City implements Serializable {
    public  String insee	;// Code insee de la commune
	public  int cp ; // Code postal de la commune


    public   double latitude;	 //	Latitude décimale de la commune
    public  double longitude;	//	Longitude décimale de la commune
    public   int altitude	; //	Altitude de la commune en mètres
    public   String name	; //	Nom de la commune

    public City(String insee, String name, int cp, double latitude, double longitude, int altitude) {
        this.insee = insee;
        this.cp = cp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.name = name;
    }

    public City() {

    }

    public String getInsee() {
        return insee;
    }

    public int getCp() {
        return cp;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getAltitude() {
        return altitude;
    }
    @Override
    public String toString(){
        Uti.info("City","toString()","");
        return "Code insee : "+this.insee+ "\nVille : " +this.name +"\nCode postal "+this.cp+"\nLongitude "+this.longitude+"\nLatitude "+this.latitude+"\nAltitude "+this.altitude;
    }


}
