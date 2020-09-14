package monApplication.item_answer;

import monApplication.CityWeatherInformations;
import monApplication.MaFen;
import monApplication.classApi.City;

import javax.swing.*;
import java.awt.*;

public class ItemAnswerCity/* extends JPanel */{
    private MaFen maFen;
    private JLabel title;
    public CityWeatherInformations cityWeatherInformations;
    public ItemAnswerCity(MaFen maFen, City city) throws CityNullException {
        if(city== null)
            throw new CityNullException();
        else {
            this.maFen= maFen;
            title = new JLabel("");
            // todo à réorganiser pour les éléments de la liste cities
            title.setText(city.getName()) ;
            cityWeatherInformations = new CityWeatherInformations(city);
            maFen.bottom.add(this.title, BorderLayout.NORTH);
//        add(this.title);
//        maFen.bottom.add(this);
//        defineSize();
//        this.setBackground(Color.green);
        }


    }
//    public void defineSize(){
//        this.setSize(maFen.bottom.getWidth(),200);
//    }
}
