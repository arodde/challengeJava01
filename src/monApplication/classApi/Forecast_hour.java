package monApplication;
import org.joda.time.DateTime;
public class Forecast_hour {
    String	 insee;// Code Insee de la commune
    float	 latitude	;// 	Latitude décimale de la commune
    float	    longitude	;// Longitude décimale de la commune
    DateTime	datetime		;// Date en heure locale, format ISO8601
    Integer	 temp2m;// 	Température à 2 mètres en °C
    Integer	 rh2m	;// Humidité à 2 mètres en %
    Integer	 wind10m		;// Vent moyen à 10 mètres en km/h
    Integer		 gust10m;// Rafales de vent à 10 mètres en km/h
    Integer	dirwind10m	;// Direction du vent en degrés (0 à 360°)
    float	 rr10	;// 	Cumul de pluie sur la tranche horaire ou tri-horaire en mm
    float	 rr1	;// 	Cumul de pluie maximal sur la tranche horaire ou tri-horaire en mm
    Integer	probarain	;// 	Probabilité de pluie entre 0 et 100%
    Integer	weather	;// Temps sensible (Code temps) – Voir Annexes
    Integer		 probafrost	;// Probabilité de gel entre 0 et 100%
    Integer		 probafog	;// Probabilité de brouillard entre 0 et 100%
    Integer	probawind70		;// Probabilité de vent >70 km/h entre 0 et 100%
    Integer	 probawind100	;// 	Probabilité de vent >100 km/h entre 0 et 100%
    Integer	  tsoil1	;// 	Température du sol entre 0 et 10 cm en °C
    Integer		 tsoil2	;// Température du sol entre 10 et 40 cm en °C.
    Integer	 gustx		;// Rafale de vent potentielle sous orage ou grain en km/h
    Integer	 iso0		;// Altitude du isotherme 0°C en mètres
}
