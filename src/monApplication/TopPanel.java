package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

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
        setPreferredSize(new Dimension(this.getWidth(), 50));
        this.maFen = maFen;
        preparation();
        positionOnMaFen();
    }
    public void preparation(){
        Uti.info("TopPanel", "preparation","");
//        cityWeatherInformations.setText("");
        cityWeatherInformations.setSize(200,60);
        cityWeatherInformations.setBackground(Color.CYAN);
        cityWeatherInformations.setBackground(Color.white);
        errorLabel.setSize(new Dimension(200,60));
        errorLabel.setBackground(Color.white);
        cityLabel.setText("Ville : ");
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
    class TestConnection {
        /**
         * test the internet connection
         */

//        Thread threadOfConnection;


//
//        public void testInternetConnection2() {
//            Uti.info("TestConnection", "testInternetConnection2", "");
//            /**
//             * check if the internet's connection orders and if the url is real.
//
//            check the text in jEditorPaneCity
//            if it 's different of "" or null
//             */
////            modification
////            author:
////            AR
////            release 0.0.2
////            date 20200716
//            if (cityWeatherInformations.getText().trim() != "" || cityWeatherInformations != null) {
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
//
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


        // modification
        // author: AR
        // release 0.0.1
        // date 20200716
        public void displayServerResponse(int value){
            switch (value) {
                case 200:
                    System.out.println("Ok connexion établie, connexion à l'api");
                    break;
                case 400:
                    System.out.println("Nom de commune non trouvé dans la liste de communes de l'api");
                    break;
                case 401:
                    System.out.println("Token absent ou invalide");
                    break;
                case 403:
                    System.out.println("Nombre de requêtes autorisées par l'abonnement déjà atteint");
                    break;
                case 404:
                    System.out.println("Url d'api inconnue");
                    break;
                case 500:
                    System.out.println("Le serveur présente une erreur");
                    break;
                case 503:
                    System.out.println("Service de l'api actuellement indisponible");
                    break;
                default:
                    System.out.println("cas d'erreur non prêvu par l'api.");
                    break;
            }
        }
        public void testInternetConnection() throws UnknownHostException, IOException {
            /**
             * function which confirms the internet connection
             * or precises the cause of problem of connection.
             */
            Uti.info("TestConnection", "testConnectionInternet()", "");
            try {
                try {
                    URL url = new URL("http://www.google.com");
                    System.out.println(url.getHost());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();
                    displayServerResponse(httpURLConnection.getResponseCode());

//                    if (con.getResponseCode() == 200) {
//                        System.out.println("Connection established!!");
//                    }
                } catch (Exception exception) {
                    System.out.println("No Connection");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
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
