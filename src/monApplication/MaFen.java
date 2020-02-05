package monApplication;

import uti.Uti;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MaFen extends JFrame {
    public JLabel jLabel = new JLabel();
    public JPanel mainPanel = new JPanel();
    public JPanel interact = new JPanel();
    public JPanel result = new JPanel();
    public JEditorPane jEditorPaneCity = new JEditorPane();
    public AskApi2 askApi2 = new AskApi2();

    public static void main(String[] args) {
        MaFen mafen = new MaFen();
    }

    public MaFen() {
        Uti.info("MaFen", "MaFen()", "");
        this.setTitle("Affichage Météo par ville");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

// add borderLayout in mainPanel
        BorderLayout borderLayout = new BorderLayout();
        mainPanel.setBackground(Color.white);
        mainPanel.add(interact, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(result), BorderLayout.CENTER);
        result.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
        result.setBackground(Color.red);
        interact.setPreferredSize(new Dimension(this.getWidth(), 50));
        interact.add(jEditorPaneCity, BorderLayout.EAST);
        interact.setBackground(Color.gray);
//        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);
        // give the response to internet connection test
//        jbuttonAskWeatherInformations.addActionListener(askApi);
        jEditorPaneCity.addFocusListener(askApi2);
        // display the window
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public boolean testInternetConnection() {
        uti.Uti.info("MaFen", "testInternetConnection", "");
        /**
         *  this function test if the client is connected to internet and return a boolean
         *  true if the internet connection orders. The url is correct OR NOT correct
         *  false if the internet connection doesn't orders.
         */
        // test connection
        String testedUrl = "Xhttps://api.meteo-concept.com/documentation";
        boolean resultConnectivity = false;

        try {
            URL url = new URL(testedUrl);
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("1");
            System.out.println("Vous êtes connectés à internet");
            return true;
        } catch (MalformedURLException e) {
            System.out.println("2");
            System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
            return true;
        } catch (IOException e) {
            System.out.println("3");
            System.out.println("Une connexion à internet est requise");
            return false;
        }
    }
// todo rename askApi
// todo rename table
// todo rename request to api
// todo rename display table
// todo rename 
// todo rename



    class AskApi2 implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            // check the text in jEditorPaneCity
            // if it's different of "" or null
            if(jEditorPaneCity.getText()!=""||jEditorPaneCity!= null)
            {
                //      check internet connection
                if(testInternetConnection()){
                    //      if connection ok
                    //          create thread
                    //          stock recept data
                    System.out.println("ok test");
                }
                else
                {
                    System.out.println("Ahhhhhhhhhhhh!!!");
                }
            }


        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

}