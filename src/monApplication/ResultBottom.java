package monApplication;

import monApplication.item_answer.CityNullException;
import uti.Uti;

import javax.swing.*;
import java.awt.*;

public class ResultBottom extends JPanel {
    /**
     * The results of the API's requests display in this panel.
     */
    public MaFen maFen;
    public ResultBottom(MaFen maFen){
        Uti.info("ResultBottom", "ResultBottom", "");
        this.maFen = maFen;
        adjustBottomSize();
    }
    public void adjustBottomSize(){
        Uti.info("ResultBottom", "adjustBottomSize", "");
        setSize(new Dimension(maFen.getWidth(), ajustHeight()));
    }
    public int ajustHeight(){
        Uti.info("ResultBottom", "ajustHeight", "");
//        return maFen.heigthFrame-maFen.topPanel.cityWeatherInformations.getHeight();
        return maFen.topPanel.getHeight() - maFen.topPanel.getHeight();
    }
    public void razBottom(){
        Uti.info("ResultBottom", "razBottom", "");
        removeAll();
    }

    public void bottomAnswer(){
        Uti.info("ResultBottom", "bottomAnswer", "");
        setBackground(Color.WHITE);
        try {
            updateBottom();
        } catch (CityNullException e) {
            e.printStackTrace();
        }
    }
    public void updateBottom() throws CityNullException {
        Uti.info("ResultBottom", "updateBottom", "");
        razBottom();
        setSize(maFen.dimensionFrame.width,maFen.dimensionFrame.height-maFen.topPanel.getHeight());
        for (int i =0 ; i < maFen.cities.size(); i++){
            maFen.createItemCities(i);
        }
    }
}
