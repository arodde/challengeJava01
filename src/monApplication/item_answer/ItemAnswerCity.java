package monApplication.item_answer;

import monApplication.CityWeatherInformations;
import monApplication.MaFen;
import monApplication.classApi.City;

import javax.swing.*;
import java.awt.*;

public class ItemAnswerCity extends JPanel {
    private MaFen maFen;
    private JLabel title;
    public CityWeatherInformations cityWeatherInformations;
    public ItemAnswerCity(MaFen maFen, City city) throws CityNullException {
        if(city== null)
            throw new CityNullException();
        else {
            this.maFen= maFen;
            title = new JLabel("");
            title.setText(city.getName()) ;
            setMaximumSize(new Dimension(maFen.getWidth(),title.getHeight()*7));
            cityWeatherInformations = new CityWeatherInformations(city);
            maFen.resultBottom.add(this.title, BorderLayout.NORTH);
        }
    }
}
