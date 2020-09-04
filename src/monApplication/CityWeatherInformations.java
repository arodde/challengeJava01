package monApplication;

import monApplication.classApi.City;

import javax.swing.*;

public class CityWeatherInformations {

    public JTable infoCityJTable;
    public CityWeatherInformations(City city){


        //Les données du tableau
        Object[][] data = {
                {"Code insee", city.getInsee()},
                {"Nom", city.getName()},
                {"Code postal", city.getCp()},
                {"Latitude", city.getLatitude()},
                {"Longitude", city.getLongitude()},
                {"Altitude", city.getAltitude()}
        };


        //Les titres des colonnes
        String  title[] = {"Caractéristique", "Donnée"};
        infoCityJTable = new JTable(data, title);
        //        this.setDefaultCloseOperation(JTableExample.EXIT_ON_CLOSE);
//        this.setTitle("JTable");
//        this.setSize(300, 120);
//        this.getContentPane().add(jPanel);
//        //Les données du tableau
//        Object[][] data = {
//                {"Cysboy", "28 ans", "1.80 m"},
//                {"BZHHydde", "28 ans", "1.80 m"},
//                {"IamBow", "24 ans", "1.90 m"},
//                {"FunMan", "32 ans", "1.85 m"}
//        };
//
//        //Les titres des colonnes
//        String  title[] = {"Pseudo", "Age", "Taille"};
//        JTable tableau = new JTable(data, title);
//        //Nous ajoutons notre tableau à notre contentPane dans un scroll
//        //Sinon les titres des colonnes ne s'afficheront pas !
//        jPanel.add(new JScrollPane(tableau));
    }
}
