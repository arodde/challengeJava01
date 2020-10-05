package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class TopPanel extends JPanel {
    /**
     * This panel is the part of frame with which the user interact for the application.
     * the button serves to ask to api the information with the request
     */

    public MaFen maFen;
    public JLabel cityLabel = new JLabel();
    public JTextField cityWeatherInformations = new JTextField ("                           ");
    public JLabel errorLabel = new JLabel();
    public JButton askSearchButton;
    public SendRequestListener sendRequestListener = new SendRequestListener();
    public RequestApi requestApi;


    public TopPanel(MaFen maFen){
        Uti.info("TopPanel", "TopPanel","");
//        setSize(new Dimension( cityLabel.getHeight(),maFen.getWidth()));
        this.maFen = maFen;
        resizeInFrame();
        preparation();

        positionOnTopPanel();
    }
    public void preparation(){
        Uti.info("TopPanel", "preparation","");

        cityWeatherInformations.setSize(maFen.getWidth(),cityLabel.getHeight());
        cityWeatherInformations.setBackground(Color.white);
//        errorLabel.setSize(new Dimension(500,60));
        cityLabel.setText("code insee: ");
//        this.setMaximumSize(new Dimension(maFen.getWidth(),cityLabel.getHeight()));
        askSearchButton = new JButton("Demander informations");
        askSearchButton.addActionListener(sendRequestListener);
        colorationElements();
    }
    public void colorationElements(){

        setBackground(Color.gray);
//        cityLabel.setBackground(Color.green);
//        cityWeatherInformations.setBackground(Color.);
//        askSearchButton.setBackground(Color.gray);
//        errorLabel.setBackground(Color.red);
    }

    public void positionOnTopPanel(){
        Uti.info("TopPanel", "positionOnTopPanel","");
        add(cityLabel);
        add(cityWeatherInformations);
        add(errorLabel);
        add(askSearchButton);
    }
    public void positionOnTopPanel2(){
        Uti.info("TopPanel", "positionOnTopPanel","");
        add(cityLabel, BorderLayout.WEST);
        add(cityWeatherInformations, BorderLayout.CENTER);
        add(errorLabel, BorderLayout.EAST);
        add(askSearchButton,BorderLayout.SOUTH);
    }
    public void resizeInFrame(){
        Uti.info("SendRequestListener", "actionPerformed","");
//        this.setSize(maFen.getWidth(),     cityLabel.getMaximumSize().height*2);
        this.setSize(maFen.getWidth(),     35);
    }


    class SendRequestListener implements ActionListener , Runnable{
        @Override
        public void actionPerformed(ActionEvent e) {
            Uti.info("SendRequestListener", "actionPerformed","");
            cityWeatherInformations.getText().trim();

            run();
        }

        @Override
        public void run() {
            System.out.println("début thread");
            TestConnection testConnection = new TestConnection();
            try {
                testConnection.testInternetConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            maFen.cities.clear();
            requestApi = new RequestApi(maFen);
            maFen.resultBottom.setVisible(true);
//            maFen.topPanel.setSize(maFen.dimensionFrame.width,40);
            maFen.adjustSizeContent();
//            maFen.resultBottom.setBackground(Color.red);
            System.out.println("fin thread");
        }
    }
}
