package monApplication;

import monApplication.classApi.City;

import javax.swing.*;
import java.awt.*;

public class CityWeatherInformations {

    public JTable infoCityJTable;
    public CityWeatherInformations(City city){

        Object[][] data = {
                {"Code insee", city.getInsee()},
                {"Nom", city.getName()},
                {"Code postal", city.getCp()},
                {"Latitude", city.getLatitude()},
                {"Longitude", city.getLongitude()},
                {"Altitude", city.getAltitude()}
        };
        String  title[] = {"Caractéristique", "Donnée"};

        infoCityJTable = new JTable(data, title);
        infoCityJTable.setMinimumSize(new Dimension(500,120));

    }
}
