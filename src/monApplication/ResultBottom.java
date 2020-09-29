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
    Uti.info("ResultBottom", "adjustBottomSize", "");
    this.maFen = maFen;
}
    public void adjustBottomSize(){
        Uti.info("ResultBottom", "adjustBottomSize", "");
        setPreferredSize(new Dimension(maFen.getWidth(), maFen.getHeight()-90));
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
        for (int i =0 ; i < maFen.cities.size(); i++){
            maFen.createItemCities(i);
        }
    }
}
