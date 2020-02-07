package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class MaFen extends JFrame {
    public JLabel jLabelCity = new JLabel();
    public JTextField jTextField = new JTextField();
    public JLabel jLabel = new JLabel();
    public JPanel interact = new JPanel();
    public JPanel result = new JPanel();
    public JPanel mainPanel = new JPanel();
    public TestConnection testConnection = new TestConnection();
    public JTable weatherJTable;
    //    public JButton buttonAskWeatherInformations = new JButton();
    public URL testedUrl;
    public String request = "";
    public String stringJSON ="";
    public RequestApi requestApi = new RequestApi();


    public static void main(String[] args) {
        MaFen mafen = new MaFen();
    }

    public MaFen() {
        Uti.info("MaFen", "MaFen()", "");
        /**
         * constructor
         * add fields in window
         */
        this.setTitle("Affichage Météo par ville");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

// add borderLayout in mainPanel
        BorderLayout borderLayout = new BorderLayout();
        // préparation components
        jTextField.setSize(200,60);
        jTextField.setBackground(Color.CYAN);
        jTextField.setBackground(Color.white);
        jTextField.addFocusListener(testConnection);
        jTextField.setText("                     ");
        jLabel.setSize(new Dimension(200,60));
        jLabel.setBackground(Color.white);
        jLabelCity.setText("Ville : ");
        result.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
        result.setBackground(Color.red);
        interact.setPreferredSize(new Dimension(this.getWidth(), 50));
//        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);
        // give the response to internet connection test
        // add elements
        interact.add(jLabelCity, BorderLayout.WEST);
        interact.add(jTextField, BorderLayout.CENTER);
        interact.add(jLabel, BorderLayout.WEST);
        interact.setBackground(Color.gray);
        mainPanel.setBackground(Color.white);
        mainPanel.add(interact, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(result), BorderLayout.CENTER);
//        jbuttonAskWeatherInformations.addActionListener(askApi);
        // display the window
        this.setContentPane(mainPanel);
        this.setVisible(true);
//        testedUrl = new URL(requestApi.url);
    }

    public boolean testInternetConnection() {
        uti.Uti.info("MaFen", "testInternetConnection", "");
        /**
         *  this function test if the client is connected to internet and return a boolean
         *  true if the internet connection orders. The url is correct OR NOT correct
         *  false if the internet connection doesn't orders.
         */
        // test connection
//        String testedUrl = "https://openclassrooms.com/";
        String testedUrl = "https://api.meteo-concept.com/api/";
//        boolean resultConnectivity = false;

        try {
            URL url = new URL(testedUrl);
            URLConnection connection = url.openConnection();

            connection.connect();
            System.out.println("1");
            System.out.println("Vous êtes connectés à internet");
            jLabel.setText("Vous êtes connectés à internet");
            return true;
        } catch (MalformedURLException e) {
            System.out.println("2");
            System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
            jLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
            return false;
        } catch (IOException e) {
            System.out.println("3");
            System.out.println("Une connexion à internet est requise");
            jLabel.setText("Une connexion à internet est requise");
            return false;
        }
    }

// todo  table
// todo  request to api
// todo  display table
// todo  search request api
// todo ?

/*
    public void CreateMyWeatherDataJtable(){


        // Data to be displayed in the JTable
        String[][] data = {
                { "a1", "b1", "c1" },
                { "a2", "b2", "c2" }
        };

        // Column Names
        String[] columnNames = { "a", "b", "c" };

        // Initializing the JTable
        weatherJTable = new JTable(data, columnNames);
        weatherJTable.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(weatherJTable);
        this.add(sp);
    }
*/

    class TestConnection implements FocusListener {
        /**
         * test the internet connection
         */

        Thread threadOfConnection;
        @Override
        public void focusGained(FocusEvent e) {
            /**
             * check if the internet's connection orders and if the url is real.
             */
            // check the text in jEditorPaneCity
            // if it's different of "" or null
            if(jTextField.getText()!=""|| jTextField != null)
            {
                //      check internet connection
                boolean connectionOk= false;
                if(testInternetConnection()){
                    //      if connection ok
                    //          create thread
                    //          stock recept data
                    System.out.println("ok test");
                    // check if the internet's connection orders and if the url is real.
                    connectionOk = testInternetConnection();
                    request = testedUrl + "";
//                    requestApi.url = testedUrl;
                    threadOfConnection = new Thread(new CallAPI(requestApi,stringJSON)); // need url with town and token
                    threadOfConnection.start();
                }
                else
                {
                    System.out.println("échec de connexion");
                }
            }


        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

}