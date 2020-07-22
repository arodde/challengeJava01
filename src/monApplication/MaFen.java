package monApplication;


import org.json.simple.JSONObject;
import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;


public class MaFen extends JFrame implements FocusListener {
    // modification
    // author: AR
    // release 0.0.1
    // date 20200716
//    public JLabel cityLabel = new JLabel();
//    public JTextField cityWeatherInformations = new JTextField();
//    public JLabel errorLabel = new JLabel();
//    public JPanel top = new JPanel();
//
//    public JPanel bottom = new JPanel();
//    public JPanel mainPanel = new JPanel();
//    public JTable weatherJTable;
//    //    public JButton buttonAskWeatherInformations = new JButton();
//
//    public TestConnection testConnection = new TestConnection();
//    public URL testedUrl;
//    public String request = "";
//    public String stringJSON ="";
//    public RequestApi requestApi = new RequestApi();
//    public JSONObject jsonObject=null;

    public TopPanel topPanel;
    public JPanel bottom;
    public JTable cityWeatherInformationJTable;
    public JPanel mainPanel = new JPanel();

    public TestConnection testConnection = new TestConnection();
    public JSONObject jsonObject = null;
    // todo add an Arraylist of answerJPanel. the answerJPanel is composed of a title and jtable.

    public static void main(String[] args) {
        Uti.info("", "", "");
        MaFen mafen = new MaFen();

//        // serialization/deserialization test. It doesn't order with JSON
//             Uti.utilisationSerializationAndDeserializationFile();
        /*
            TutorialJSONSimple tutorialJSONSimple= new TutorialJSONSimple();
            String s = "xyztmp/tutoJsonSimple/city.json";
            City myCity = tutorialJSONSimple.displaysCityJSONStringContentFromJsonFile(s);
            System.out.println(myCity.toString());
        */
    }

    // modification
    // author: AR
    // release 0.0.1
    // date 20200716
//    public MaFen() {
//        Uti.info("MaFen", "MaFen()", "");
//        /**
//         * constructor
//         * add fields in window
//         */
//        this.setTitle("Affichage Météo par ville");
//        this.setSize(600, 600);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//
//// add borderLayout in mainPanel
//        BorderLayout borderLayout = new BorderLayout();
//        // préparation components
//        cityWeatherInformations.setSize(200,60);
//        cityWeatherInformations.setBackground(Color.CYAN);
//        cityWeatherInformations.setBackground(Color.white);
//        cityWeatherInformations.addFocusListener(testConnection);
//        cityWeatherInformations.setText("                                ");
//        errorLabel.setSize(new Dimension(200,60));
//        errorLabel.setBackground(Color.white);
//        cityLabel.setText("Ville : ");
////        jTextField.requestFocusInWindow();// get the focus on the textfield
//        bottom.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
//        bottom.setBackground(Color.pink);
//
//        top.setPreferredSize(new Dimension(this.getWidth(), 50));
////        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);
//        // give the response to internet connection test
//        // add elements
//        top.add(cityLabel, BorderLayout.WEST);
//        top.add(cityWeatherInformations, BorderLayout.CENTER);
//        top.add(errorLabel, BorderLayout.WEST);
//        top.setBackground(Color.gray);
//        mainPanel.setBackground(Color.white);
//        mainPanel.add(topPanel, BorderLayout.NORTH);
//        mainPanel.add(new JScrollPane(bottom), BorderLayout.CENTER);
////        jbuttonAskWeatherInformations.addActionListener(askApi);
//        // display the window
//        this.setContentPane(mainPanel);
//        this.setVisible(true);
////        testedUrl = new URL(requestApi.url);
//    }
    // modification
    // author: AR
    // release 0.0.2
    // date 20200716
//    public MaFen() {
//        Uti.info("MaFen", "MaFen()", "");
//        /**
//         * constructor
//         * add fields in window
//         */
//        this.setTitle("Affichage Météo par ville");
//        this.setSize(600, 600);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//
//// add borderLayout in mainPanel
//        BorderLayout borderLayout = new BorderLayout();
//        topPanel = new TopPanel();
//        bottom = new JPanel();
//        bottom.setBackground(Color.pink);
//        topPanel.cityWeatherInformations.addFocusListener(testConnection);
////        jTextField.requestFocusInWindow();// get the focus on the textfield
//        bottom.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
////        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);
//        topPanel.setPreferredSize(new Dimension(this.getWidth(), 50));
//        mainPanel.setBackground(Color.white);
//        mainPanel.add(topPanel, BorderLayout.NORTH);
//        mainPanel.add(new JScrollPane(bottom), BorderLayout.CENTER);
////        jbuttonAskWeatherInformations.addActionListener(askApi);
//        // display the window
//        this.setContentPane(mainPanel);
//        this.setVisible(true);
////        testedUrl = new URL(requestApi.url);
//    }
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
        topPanel = new TopPanel(this);
//        requestApi = new RequestApi(this);
        bottom = new JPanel();
        bottom.setBackground(Color.pink);
        topPanel.cityWeatherInformations.addFocusListener(this);
//        jTextField.requestFocusInWindow();// get the focus on the textfield
        bottom.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
//        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);
        topPanel.setPreferredSize(new Dimension(this.getWidth(), 50));
        mainPanel.setBackground(Color.white);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(bottom), BorderLayout.CENTER);
//        jbuttonAskWeatherInformations.addActionListener(askApi);
        // display the window
        this.setContentPane(mainPanel);
        this.setVisible(true);
//        testedUrl = new URL(requestApi.url);
    }
//    public boolean testInternetConnection() {
//        Uti.info("MaFen", "testInternetConnection", "rrrr");
//        /**
//         *  this function test if the client is connected to internet and return a boolean
//         *  true if the internet connection orders. The url is correct OR NOT correct
//         *  false if the internet connection doesn't orders.
//         */
//        // test connection
////        String testedUrl = "https://openclassrooms.com/";
//        String testedUrl = "https://api.meteo-concept.com/api/";
//        // modification
//        // author: AR
//        // release 0.0.1
//        // date 20200716
////        try {
////            URL url = new URL(testedUrl);
////            URLConnection connection = url.openConnection();
////
////            connection.connect();
////            System.out.println("1");
////            System.out.println("Vous êtes connectés à internet");
////            errorLabel.setText("Vous êtes connectés à internet");
////            return true;
////        } catch (MalformedURLException e) {
////            System.out.println("2");
////            System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
////            errorLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
////            return false;
////        } catch (IOException e) {
////            System.out.println("3");
////            System.out.println("Une connexion à internet est requise");
////             errorLabel.setText("Une connexion à internet est requise");
//
////            return false;
////        }
//        try {
//            URL url = new URL(testedUrl);
//            URLConnection connection = url.openConnection();
//            connection.connect();
//            System.out.println("1");
//            System.out.println("Vous êtes connectés à internet");
//            topPanel.errorLabel.setText("Vous êtes connectés à internet");
//            return true;
//        } catch (MalformedURLException e) {
//            System.out.println("2");
//            System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
//            topPanel.errorLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
//            return false;
//        } catch (IOException e) {
//            System.out.println("3");
//            System.out.println("Une connexion à internet est requise");
//            topPanel.errorLabel.setText("Une connexion à internet est requise");
//            return false;
//        }
//    }


    @Override
    public void focusGained(FocusEvent e) {
        Uti.info("MaFen","focusGained","");
        try {
            testConnection.preliminaryTestInternetConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    @Override
    public void focusLost(FocusEvent e) {
        Uti.info("MaFen","focusLost","");
        try {
            testConnection.preliminaryTestInternetConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

// todo  table
// todo  request to api
// todo  display table
// todo  search request api
// todo ?

    /*
        public void CreateMyWeatherDataJtable(){
    Uti.info("MaFen","CreateMyWeatherDataJtable","");


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
    // modification
    // author: AR
    // release 0.0.2
    // date 20200716
//    class TestConnection implements FocusListener {
//        /**
//         * test the internet connection
//         */
//
//        Thread threadOfConnection;
//
//        @Override
//        public void focusGained(FocusEvent e) {
//            Uti.info("TestConnection", "focusGained", "");
//
//
//        }
//
//        @Override
//        public void focusLost(FocusEvent e) {
//            Uti.info("TestConnection", "focusLost", "");
//            /**
//             * check if the internet's connection orders and if the url is real.
//             */
//            // check the text in jEditorPaneCity
//            // if it's different of "" or null
//            // modification
//            // author: AR
//            // release 0.0.1
//            // date 20200716
////            if(cityWeatherInformations.getText()!=""|| cityWeatherInformations != null)
////            {
////                //      check internet connection
////                boolean connectionOk= false;
////                if(testInternetConnection()){
////                    //      if connection ok
////                    //          create thread
////                    //          stock recept data
////                    System.out.println("ok test");
////                    // check if the internet's connection orders and if the url is real.
////                    connectionOk = testInternetConnection();
////                    request = testedUrl + "";
//////                    requestApi.url = testedUrl;
////                    threadOfConnection = new Thread(new CallAPI(requestApi,stringJSON)); // need url with town and token
////                    threadOfConnection.start();
////                }
////                else
////                {
////                    System.out.println("échec de connexion");
////                }
////            }
//            if (topPanel.cityWeatherInformations.getText() != "" || topPanel.cityWeatherInformations != null) {
//                //      check internet connection
//                boolean connectionOk = false;
//                if (testInternetConnection()) {
//                    //      if connection ok
//                    //          create thread
//                    //          stock recept data
//                    System.out.println("ok test");
//                    // check if the internet's connection orders and if the url is real.
//                    connectionOk = testInternetConnection();
//                    request = testedUrl + "";
////                    requestApi.url = testedUrl;
//                    threadOfConnection = new Thread(new CallAPI(requestApi, stringJSON)); // need url with town and token
//                    threadOfConnection.start();
//                } else {
//                    System.out.println("échec de connexion");
//                }
//            }
//        }
//
//        // modification
//        // author: AR
//        // release 0.0.1
//        // date 20200716
//        public void testConnectionInternet() throws UnknownHostException, IOException {
//            /**
//             * function which confirms the internet connection
//             * or precises the cause of problem of connection.
//             */
//            try {
//                try {
//                    URL url = new URL("http://www.google.com");
//                    System.out.println(url.getHost());
//                    HttpURLConnection con = (HttpURLConnection) url
//                            .openConnection();
//                    con.connect();
//                    switch (con.getResponseCode()){
//                        case 200 :
//                            System.out.println("Ok connexion établie, connexion à l'api");
//                            break;
//                        case 400 :
//                            System.out.println("Nom de commune non trouvé dans la liste de communes de l'api");
//                            break;
//                        case 401 :
//                            System.out.println("Token absent ou invalide");
//                            break;
//                        case 403 :
//                            System.out.println("Nombre de requêtes autorisées par l'abonnement déjà atteint");
//                            break;
//                        case 404 :
//                            System.out.println("Url d'api inconnue");
//                            break;
//                        case 500 :
//                            System.out.println("Le serveur présente une erreur");
//                            break;
//                        case 503 :
//                            System.out.println("Service de l'api actuellement indisponible");
//                            break;
//                        default :
//                            System.out.println("cas d'erreur non prêvu par l'api.");
//                            break;
//                    }
////                    if (con.getResponseCode() == 200) {
////                        System.out.println("Connection established!!");
////                    }
//                } catch (Exception exception) {
//                    System.out.println("No Connection");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
// modification
// author: AR
// release 0.0.2
// date 20200716
//    class CityWeatherInformations extends JTextField/* implements FocusListener*/{
////        public TestConnectionB testConnectionB = new TestConnectionB();
////        @Override
////        public void focusGained(FocusEvent e) {
////            Uti.info("CityWeatherInformations","focusGained","");
////            try {
////                testConnectionB.testConnectionInternet();
////            } catch (IOException ioException) {
////                ioException.printStackTrace();
////            }
////
////        }
////        @Override
////        public void focusLost(FocusEvent e) {
////            Uti.info("CityWeatherInformations","focusLost","");
////            try {
////                testConnectionB.testConnectionInternet();
////            } catch (IOException ioException) {
////                ioException.printStackTrace();
////            }
////        }
//    }


}