package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
// modification
// author: AR
// release 0.0.1
// date 20200716
public class TopPanel extends JPanel {
    /**
     * This panel is the part of frame with which the user interact for the application
     */
    public JLabel cityLabel = new JLabel();
    public JTextField cityWeatherInformations = new JTextField();
    public JLabel errorLabel = new JLabel();
    public TopPanel(){
        Uti.info("TopPanel", "TopPanel","");
        setPreferredSize(new Dimension(this.getWidth(), 50));/
        preparation();
        positionOnMaFen();
    }
    public void preparation(){
        Uti.info("TopPanel", "preparation","");
        cityWeatherInformations.setSize(200,60);
        cityWeatherInformations.setBackground(Color.CYAN);
        cityWeatherInformations.setBackground(Color.white);
        cityWeatherInformations.setText("                                ");
        errorLabel.setSize(new Dimension(200,60));
        errorLabel.setBackground(Color.white);
        cityLabel.setText("Ville : ");
        setPreferredSize(new Dimension(this.getWidth(), 50));
    }
    public void positionOnMaFen(){
        Uti.info("TopPanel", "positionOnMaFen","");
        add(cityLabel, BorderLayout.WEST);
        add(cityWeatherInformations, BorderLayout.CENTER);
        add(errorLabel, BorderLayout.WEST);
        setBackground(Color.gray);
    }
}
