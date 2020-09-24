package monApplication;

import monApplication.classApi.City;
import monApplication.item_answer.CityNullException;
import monApplication.item_answer.ItemAnswerCity;
import org.json.simple.JSONObject;
import uti.ManageWindowPositionInScreen;
import uti.UnpossibleMeasureException;
import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


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
    //    public City city;
    public monApplication.CityWeatherInformations cityWeatherInformations;
    public JPanel mainPanel = new JPanel();
    public JScrollPane jScrollPane  = new JScrollPane();
    public BorderLayout borderLayout= new BorderLayout();
    public TestConnection testConnection = new TestConnection();
    //    public JButton buttonAskWeatherInformations = new JButton();

    //    public TestConnection testConnection = new TestConnection();
    public URL testedUrl;
    public String request = "";
    public String stringJSON = "";
    //    public RequestApi requestApi ;
    public JSONObject jsonObject = null;
    public ItemAnswerCity itemAnswerCity;
    public ArrayList<City> cities = new ArrayList<City>();
    public int widthFrame = 500;
    public int heigthFrame = 500;
    public Dimension dimensionFrame = new Dimension(widthFrame,heigthFrame);
    // todo add an Arraylist of answerJPanel. the answerJPanel is composed of a title and jtable.

    public static void main(String[] args) {
        Uti.info("", "", "");
        MaFen mafen = new MaFen();
    }


    public MaFen() {
        Uti.info("MaFen", "MaFen()", "");
        /**
         * constructor
         * add fields in window
         */
        frameInitialization();

// add borderLayout in mainPanel
        topPanelSetting();
        bottomSetting();
        mainPanelLayout();
        addScrollPaneToMaFen();
        this.setVisible(true);
    }
    public void frameInitialization(){
        Uti.info("MaFen", "frameInitialization", "");
        this.setTitle("Affichage Météo par ville");
        this.setSize(dimensionFrame);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        postionFrameInScreen(75,75);
    }
    private void postionFrameInScreen(int posX,int posY){
        try {
            ManageWindowPositionInScreen manageWindowPositionInScreen = new ManageWindowPositionInScreen(this,posX, posY);
        } catch (UnpossibleMeasureException e) {
            e.printStackTrace();
            ManageWindowPositionInScreen.informations(
                    Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height
            );
        }
    }
    public void topPanelSetting(){
        Uti.info("MaFen", "topPanelSetting", "");
        topPanel = new TopPanel(this);
        topPanel.cityWeatherInformations.addFocusListener(this);
        topPanel.setPreferredSize(new Dimension(widthFrame, 50));
    }
    public void bottomSetting(){
        Uti.info("MaFen", "bottomSetting", "");
        bottom = new JPanel();
        bottom.setBackground(Color.black);
//        bottom.setLayout(borderLayout);
    }
    public void bottomAnswer(){
        Uti.info("MaFen", "bottomAnswer", "");
        bottom.setBackground(Color.WHITE);
        try {
            updateBottom();
        } catch (CityNullException e) {
            e.printStackTrace();
        }
    }
    public void updateBottom() throws CityNullException {
        Uti.info("MaFen", "updateBottom", "");
        razBottom();
        for (int i =0 ; i < cities.size(); i++){
            createItemCities(i);
        }
    }
    public void razBottom(){
        Uti.info("MaFen", "razBottom", "");
        bottom.removeAll();
    }
    public void createItemCities(int i) throws CityNullException {
        Uti.info("MaFen", "createItemCities", "");
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
        ItemAnswerCity itemAnswerCity = new ItemAnswerCity(this,cities.get(i));
        bottom.add(itemAnswerCity.cityWeatherInformations.infoCityJTable);
    }


    public void adjustSizeContent(){
        Uti.info("MaFen", "adjustSizeContent", "");
        bottom.getInsets();
        getInsets();
    }
    public void adjustBottomSize(){
        Uti.info("MaFen", "adjustBottomSize", "");
        bottom.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-90));
    }
    public void mainPanelLayout2(){
        Uti.info("MaFen", "mainPanelLayout", "");
        mainPanel.setBackground(Color.yellow);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(bottom),BorderLayout.SOUTH);

    }
    public void mainPanelLayout(){
        Uti.info("TestAlignement","mainPanelLayout","");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(topPanel);
        mainPanel.add(new JScrollPane(bottom));
    }

    public void addScrollPaneToMaFen(){
        Uti.info("TestAlignement","addScrollPaneToMaFen","");
        /**T
         * para 1 : target of the JScrollPane
         */
        jScrollPane = new JScrollPane(mainPanel);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane);
    }
    public boolean testInternetConnection() {
        Uti.info("MaFen", "testInternetConnection", "");
        /**
         *  this function test if the client is connected to internet and return a boolean
         *  true if the internet connection orders. The url is correct OR NOT correct
         *  false if the internet connection doesn't orders.
         */
        // test connection
//        String testedUrl = "https://openclassrooms.com/";
        String testedUrl = "https://api.meteo-concept.com/api/";
        // modification
        // author: AR
        // release 0.0.1
        // date 20200716
//        try {
//            URL url = new URL(testedUrl);
//            URLConnection connection = url.openConnection();
//
//            connection.connect();
//            System.out.println("1");
//            System.out.println("Vous êtes connectés à internet");
//            errorLabel.setText("Vous êtes connectés à internet");
//            return true;
//        } catch (MalformedURLException e) {
//            System.out.println("2");
//            System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
//            errorLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
//            return false;
//        } catch (IOException e) {
//            System.out.println("3");
//            System.out.println("Une connexion à internet est requise");
//             errorLabel.setText("Une connexion à internet est requise");

//            return false;
//        }
        try {
            URL url = new URL(testedUrl);
            apiFound(url);
            return true;
        } catch (MalformedURLException e) {
            apiNotFound();
            return false;
        } catch (IOException e) {
            missingInternetConnection();
            return false;
        }
    }
    public void apiFound(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println("1");
        System.out.println("Vous êtes connectés à internet");
        topPanel.errorLabel.setText("Vous êtes connectés à internet");
    }
    public void apiNotFound(){
        System.out.println("2");
        System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
        topPanel.errorLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
    }
    public void missingInternetConnection(){
        System.out.println("3");
        System.out.println("Une connexion à internet est requise");
        topPanel.errorLabel.setText("Une connexion à internet est requise");
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        System.out.println("maFen : FocusGained");
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        System.out.println("maFen : FocusLost");
    }


    class CityWeatherInformationsJtextFieldFocusListener extends JTextField implements FocusListener{
        public TestConnection testConnection = new TestConnection();
        @Override
        public void focusGained(FocusEvent e) {
            Uti.info("CityWeatherInformations","focusGained","");
            checkConnection();
        }
        @Override
        public void focusLost(FocusEvent e) {
            Uti.info("CityWeatherInformations","focusLost","");
            checkConnection();
        }
        public void checkConnection(){
            try {
                testConnection.testInternetConnection();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}