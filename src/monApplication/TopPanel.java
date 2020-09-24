package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// modification
// author: AR
// release 0.0.1
// date 20200716
public class TopPanel extends JPanel {
    /**
     * This panel is the part of frame with which the user interact for the application.
     * the button serves to ask to api the information with the request
     */
    // modification
    // author: AR
    // release 0.0.2
    // date 20200720
    public MaFen maFen;
    public JLabel cityLabel = new JLabel();
    public JTextField cityWeatherInformations = new JTextField ("                ");
    public JLabel errorLabel = new JLabel();
    public JButton askSearchButton;
    public SendRequestListener sendRequestListener = new SendRequestListener();
    public RequestApi requestApi;


    public TopPanel(MaFen maFen){
        Uti.info("TopPanel", "TopPanel","");
        setPreferredSize(new Dimension(maFen.getWidth(), 50));
        this.maFen = maFen;
        preparation();
        positionOnMaFen();
    }
    public void preparation(){
        Uti.info("TopPanel", "preparation","");
//        cityWeatherInformations.setText("");

        cityWeatherInformations.setSize(maFen.getWidth(),60);
        cityWeatherInformations.setBackground(Color.white);
        errorLabel.setSize(new Dimension(500,60));
        errorLabel.setBackground(Color.red);
        cityLabel.setText("Ville : ");
        this.setMaximumSize(new Dimension(maFen.getWidth(),cityLabel.getHeight()));
        askSearchButton = new JButton("Demander informations");
        askSearchButton.addActionListener(sendRequestListener);


    }
    public void positionOnMaFen(){
        Uti.info("TopPanel", "positionOnMaFen","");
        add(cityLabel, BorderLayout.WEST);
        add(cityWeatherInformations, BorderLayout.CENTER);
        add(errorLabel, BorderLayout.WEST);
        add(askSearchButton,BorderLayout.SOUTH);
        setBackground(Color.lightGray);
    }
    //    // modification
//    // author: AR
//    // release 0.0.2
//    // date 20200716
//    public TestConnection testConnection = new TestConnection();
//    class CityWeatherInformations extends JTextField implements FocusListener{
//        public TestConnection testConnection = new TestConnection();
//        @Override
//        public void focusGained(FocusEvent e) {
//           Uti.info("CityWeatherInformations","focusGained","");
//            try {
//                testConnection.testConnectionInternet();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//        @Override
//        public void focusLost(FocusEvent e) {
//            Uti.info("CityWeatherInformations","focusLost","");
//            try {
//                testConnection.testConnectionInternet();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//    }
//

    // modification
    // author: AR
    // release 0.0.2
    // date 20200716

    class SendRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("SendRequestListener", "actionPerformed","");
            cityWeatherInformations.getText().trim();
            try {
                TestConnection testConnection = new TestConnection();
               testConnection.testInternetConnection();
                requestApi = new RequestApi(maFen);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
