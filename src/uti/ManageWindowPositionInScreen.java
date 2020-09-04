package uti;

import javax.swing.*;
import java.awt.*;

public class ManageWindowPositionInScreen  {
    public JFrame jFrame;
    public double width;
    public double height;
    public int posX;
    public int posY;

    public static void informations(int width, int height) {
        System.out.println("la fenêtre doit avoir " +
                "une largeur comprise entre 0 et "+ (width-50) + " et " +
                "une hauteur doit être comprise entre 0 et "+ (height-50));
    }



    public ManageWindowPositionInScreen(JFrame jFrame, int posX, int posY) throws UnpossibleMeasureException {
        this.jFrame = jFrame;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;
        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        checkX();
        checkY();
        jFrame.setLocation(posX, posY);
    }
    public void checkX() throws UnpossibleMeasureException {
        if(posX<0||posX>width)
           throw new UnpossibleMeasureException(posX+" doit être compris entre 0 et "+ width);
    }
    public void checkY() throws UnpossibleMeasureException{
        if(posY<0||posY>width)
            throw new UnpossibleMeasureException(posY+" doit être compris entre 0 et "+ height);
    }
}
